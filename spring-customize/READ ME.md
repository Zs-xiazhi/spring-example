# BeanFactoryPostProcessor 注册调用过程
源码见： `PostProcessorRegistrationDelegate`
```java_holder_method_tree
	public static void invokeBeanFactoryPostProcessors(
			ConfigurableListableBeanFactory beanFactory, List<BeanFactoryPostProcessor> beanFactoryPostProcessors) {

		// Invoke BeanDefinitionRegistryPostProcessors first, if any.
		Set<String> processedBeans = new HashSet<>();

		if (beanFactory instanceof BeanDefinitionRegistry) {
			BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
			List<BeanFactoryPostProcessor> regularPostProcessors = new ArrayList<>();
			List<BeanDefinitionRegistryPostProcessor> registryProcessors = new ArrayList<>();

			for (BeanFactoryPostProcessor postProcessor : beanFactoryPostProcessors) {
				if (postProcessor instanceof BeanDefinitionRegistryPostProcessor) {
					BeanDefinitionRegistryPostProcessor registryProcessor =
							(BeanDefinitionRegistryPostProcessor) postProcessor;
					registryProcessor.postProcessBeanDefinitionRegistry(registry);
					registryProcessors.add(registryProcessor);
				}
				else {
					regularPostProcessors.add(postProcessor);
				}
			}

			// Do not initialize FactoryBeans here: We need to leave all regular beans
			// uninitialized to let the bean factory post-processors apply to them!
			// Separate between BeanDefinitionRegistryPostProcessors that implement
			// PriorityOrdered, Ordered, and the rest.
			List<BeanDefinitionRegistryPostProcessor> currentRegistryProcessors = new ArrayList<>();

			// First, invoke the BeanDefinitionRegistryPostProcessors that implement PriorityOrdered.
			String[] postProcessorNames =
					beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
			for (String ppName : postProcessorNames) {
				if (beanFactory.isTypeMatch(ppName, PriorityOrdered.class)) {
					currentRegistryProcessors.add(beanFactory.getBean(ppName, BeanDefinitionRegistryPostProcessor.class));
					processedBeans.add(ppName);
				}
			}
			sortPostProcessors(currentRegistryProcessors, beanFactory);
			registryProcessors.addAll(currentRegistryProcessors);
			invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);
			currentRegistryProcessors.clear();

			// Next, invoke the BeanDefinitionRegistryPostProcessors that implement Ordered.
			postProcessorNames = beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
			for (String ppName : postProcessorNames) {
				if (!processedBeans.contains(ppName) && beanFactory.isTypeMatch(ppName, Ordered.class)) {
					currentRegistryProcessors.add(beanFactory.getBean(ppName, BeanDefinitionRegistryPostProcessor.class));
					processedBeans.add(ppName);
				}
			}
			sortPostProcessors(currentRegistryProcessors, beanFactory);
			registryProcessors.addAll(currentRegistryProcessors);
			invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);
			currentRegistryProcessors.clear();

			// Finally, invoke all other BeanDefinitionRegistryPostProcessors until no further ones appear.
			boolean reiterate = true;
			while (reiterate) {
				reiterate = false;
				postProcessorNames = beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
				for (String ppName : postProcessorNames) {
					if (!processedBeans.contains(ppName)) {
						currentRegistryProcessors.add(beanFactory.getBean(ppName, BeanDefinitionRegistryPostProcessor.class));
						processedBeans.add(ppName);
						reiterate = true;
					}
				}
				sortPostProcessors(currentRegistryProcessors, beanFactory);
				registryProcessors.addAll(currentRegistryProcessors);
				invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);
				currentRegistryProcessors.clear();
			}

			// Now, invoke the postProcessBeanFactory callback of all processors handled so far.
			invokeBeanFactoryPostProcessors(registryProcessors, beanFactory);
			invokeBeanFactoryPostProcessors(regularPostProcessors, beanFactory);
		}

		else {
			// Invoke factory processors registered with the context instance.
			invokeBeanFactoryPostProcessors(beanFactoryPostProcessors, beanFactory);
		}

		// Do not initialize FactoryBeans here: We need to leave all regular beans
		// uninitialized to let the bean factory post-processors apply to them!
		String[] postProcessorNames =
				beanFactory.getBeanNamesForType(BeanFactoryPostProcessor.class, true, false);

		// Separate between BeanFactoryPostProcessors that implement PriorityOrdered,
		// Ordered, and the rest.
		List<BeanFactoryPostProcessor> priorityOrderedPostProcessors = new ArrayList<>();
		List<String> orderedPostProcessorNames = new ArrayList<>();
		List<String> nonOrderedPostProcessorNames = new ArrayList<>();
		for (String ppName : postProcessorNames) {
			if (processedBeans.contains(ppName)) {
				// skip - already processed in first phase above
			}
			else if (beanFactory.isTypeMatch(ppName, PriorityOrdered.class)) {
				priorityOrderedPostProcessors.add(beanFactory.getBean(ppName, BeanFactoryPostProcessor.class));
			}
			else if (beanFactory.isTypeMatch(ppName, Ordered.class)) {
				orderedPostProcessorNames.add(ppName);
			}
			else {
				nonOrderedPostProcessorNames.add(ppName);
			}
		}

		// First, invoke the BeanFactoryPostProcessors that implement PriorityOrdered.
		sortPostProcessors(priorityOrderedPostProcessors, beanFactory);
		invokeBeanFactoryPostProcessors(priorityOrderedPostProcessors, beanFactory);

		// Next, invoke the BeanFactoryPostProcessors that implement Ordered.
		List<BeanFactoryPostProcessor> orderedPostProcessors = new ArrayList<>(orderedPostProcessorNames.size());
		for (String postProcessorName : orderedPostProcessorNames) {
			orderedPostProcessors.add(beanFactory.getBean(postProcessorName, BeanFactoryPostProcessor.class));
		}
		sortPostProcessors(orderedPostProcessors, beanFactory);
		invokeBeanFactoryPostProcessors(orderedPostProcessors, beanFactory);

		// Finally, invoke all other BeanFactoryPostProcessors.
		List<BeanFactoryPostProcessor> nonOrderedPostProcessors = new ArrayList<>(nonOrderedPostProcessorNames.size());
		for (String postProcessorName : nonOrderedPostProcessorNames) {
			nonOrderedPostProcessors.add(beanFactory.getBean(postProcessorName, BeanFactoryPostProcessor.class));
		}
		invokeBeanFactoryPostProcessors(nonOrderedPostProcessors, beanFactory);

		// Clear cached merged bean definitions since the post-processors might have
		// modified the original metadata, e.g. replacing placeholders in values...
		beanFactory.clearMetadataCache();
	}
```
首先查看是否有`BeanDefinitionRegistryPostProcessor`类型的类。如果有：
* 如果当前`beanFactory`是`BeanDefinitionRegistry`类型的(spring默认唯一实现容器`DefaultListableBeanFactory`实现了此接口)，
调用BeanFactory已经实例化的`BeanDefinitionRegistryPostProcessor`类的`postProcessBeanDefinitionRegistry`方法。
```
            BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
			List<BeanFactoryPostProcessor> regularPostProcessors = new ArrayList<>();
			List<BeanDefinitionRegistryPostProcessor> registryProcessors = new ArrayList<>();

			for (BeanFactoryPostProcessor postProcessor : beanFactoryPostProcessors) {
				if (postProcessor instanceof BeanDefinitionRegistryPostProcessor) {
					BeanDefinitionRegistryPostProcessor registryProcessor =
							(BeanDefinitionRegistryPostProcessor) postProcessor;
					registryProcessor.postProcessBeanDefinitionRegistry(registry);
					registryProcessors.add(registryProcessor);
				}
				else {
					regularPostProcessors.add(postProcessor);
				}
			}
```
* 实例化所有实现`PriorityOrdered`接口的类，进行排序，调用 `postProcessBeanDefinitionRegistry`方法  
(此时有且只有一个bean名称`org.springframework.context.annotation.internalConfigurationAnnotationProcessor`,
类型为`ConfigurationClassPostProcessor`会被调用，因为spring通过这个类加载：  
* @ImportSource
* @Import
* @PropertySource
* @Configuration
* @ComponentScan
* @Component
* @Bean

注解标注的类，也就是说加载这个类之前，我们自定义的`@Import`加载的`BeanDefintionRegistryPostProcessor`类还没有被加载
)
```
// First, invoke the BeanDefinitionRegistryPostProcessors that implement PriorityOrdered.
			String[] postProcessorNames =
					beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
			for (String ppName : postProcessorNames) {
				if (beanFactory.isTypeMatch(ppName, PriorityOrdered.class)) {
					currentRegistryProcessors.add(beanFactory.getBean(ppName, BeanDefinitionRegistryPostProcessor.class));
					processedBeans.add(ppName);
				}
			}
			sortPostProcessors(currentRegistryProcessors, beanFactory);
			registryProcessors.addAll(currentRegistryProcessors);
			invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);
			currentRegistryProcessors.clear();

```
* 实例化所有的自定义的`BeanDefinitionRegistryPostProcessor`类型并实现`Ordered`接口的类，实例化顺序为`@Import`加载顺序,排序，
调用接口`postProcessBeanDefintionRegistry`方法。
```java_holder_method_tree
// 获取所有实现了BeanDefinitionRegistryPostProcessor接口的beanName，也就是BeanDefinition中定义的beanName
            postProcessorNames = beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
			for (String ppName : postProcessorNames) {
				if (!processedBeans.contains(ppName) && beanFactory.isTypeMatch(ppName, Ordered.class)) {
// 实例化没有在上面的过程中处理过并且实现了ordered接口的bean，添加到当前注册列表,加入到已经实例化的bean列表中
// PriorityOrdered接口继承了Order接口，因此也是Ordered类型的
					currentRegistryProcessors.add(beanFactory.getBean(ppName, BeanDefinitionRegistryPostProcessor.class));
					processedBeans.add(ppName);
				}
			}
// 排序，排序规则:PriorityOrdered 级别比Ordered级别高，按照数字排序(详见 OrderComparator类的 int doCompare(@Nullable Object o1, 
@Nullable Object o2, @Nullable OrderSourceProvider sourceProvider)方法)
            sortPostProcessors(currentRegistryProcessors, beanFactory);
			registryProcessors.addAll(currentRegistryProcessors);
// 调用postProcessBeanDefintionRegistry方法
			invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);
			currentRegistryProcessors.clear();
```
* 实例化并调用所有其他的没有实现`Ordered`接口的`BeanDefinitionRegistryPostProcessor`的`postProcessBeanDefintionRegistry`方法
* 调用所有的`BeanDefinitionRegistryPostProcessor`实现类的`postProcessBeanFactory`
```java_holder_method_tree
// Now, invoke the postProcessBeanFactory callback of all processors handled so far.
			invokeBeanFactoryPostProcessors(registryProcessors, beanFactory);
			invokeBeanFactoryPostProcessors(regularPostProcessors, beanFactory);
```
* 获取所有的`BeanFactoryPostProcessor`接口实现类,跳过上面处理过的`BeanDefinitionRegistryPostProcessor`实现类，并根据实现接口类型分类。
```java_holder_method_tree
        // 实现PriorityOrdered接口的
        List<BeanFactoryPostProcessor> priorityOrderedPostProcessors = new ArrayList<>();
        // 实现Ordered接口的
		List<String> orderedPostProcessorNames = new ArrayList<>();
        // 没有实现排序接口的
		List<String> nonOrderedPostProcessorNames = new ArrayList<>();
        // 遍历所有的BeanFactoryPostProcessor实现类，包括BeanDefinitionRegistryPostProcessor实现
		for (String ppName : postProcessorNames) {
			if (processedBeans.contains(ppName)) {
                // 如果已经实例化，则跳过（排除上面处理过的BeanDefinitionRegistryPostProcessor实现）
				// skip - already processed in first phase above
			}
			else if (beanFactory.isTypeMatch(ppName, PriorityOrdered.class)) {
                // 如果实现了PriorityOrdered接口，则实例化并添加到集合priorityOrderedPostProcessors
				priorityOrderedPostProcessors.add(beanFactory.getBean(ppName, BeanFactoryPostProcessor.class));
			}
			else if (beanFactory.isTypeMatch(ppName, Ordered.class)) {
                // 如果实现了Ordered接口，则添加到集合orderedPostProcessors
				orderedPostProcessorNames.add(ppName);
			}
			else {
                // 如果没有实现排序接口，则添加到无排序接口集合
				nonOrderedPostProcessorNames.add(ppName);
			}
		}
```
* 调用`priorityOrderedPostProcessors`的`postProcessBeanFactory`方法
* 调用`orderedPostProcessorNames`的方法
* 调用没有实现排序接口的集合的方法
## 注：@Order注解代表实现了Ordered接口。
## 总结：
    1. 调用所有BeanFactory实例化过的BeanDefinitionRegistryPostProcessor实现类，按照排序接口进行排序
    2. 调用ConfigurationClassPostProcessor，加载配置类
    3. 实例化所有自定义BeanDefinitionRegistryPostProcessor实现类
    4. 按照排序接口进行排序，
    5. 调用postProcessBeanDefinitionRegistry方法
    6. 实例化所有没有排序接口的BeanDefinitionRegistryPostProcessor并调用postProcessorBeanDefinitionRegistry方法
    7. 调用上面实例化所有类的postProcessBeanFactory方法
    8. 加载所有的BeanFactoryPostProcessor实现类
    9. 排除上面BeanDefinitionRegistryPostProcessor接口的实现类
    10. 实例化并排序，调用postProcessBeanFactory方法


