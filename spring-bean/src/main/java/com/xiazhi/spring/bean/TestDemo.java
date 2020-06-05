package com.xiazhi.spring.bean;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/30
 **/
public class TestDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(ServiceA.class);
        builder.addPropertyValue("name", "zhangsan");
        BeanDefinition beanDefinition = builder.getBeanDefinition();


        BeanDefinition serviceBDefinition = BeanDefinitionBuilder.genericBeanDefinition(ServiceB.class)
                .addPropertyValue("age", 18).getBeanDefinition();
        serviceBDefinition.setParentName("serviceA");

        factory.registerBeanDefinition("serviceA", beanDefinition);
        factory.registerBeanDefinition("serviceB",serviceBDefinition);

        for (String name : factory.getBeanDefinitionNames()) {
            System.out.println(name + "-->原始BeanDefinition:---->" + factory.getBeanDefinition(name).getPropertyValues());
            System.out.println(name + "-->合并BeanDefinition:---->" + factory.getMergedBeanDefinition(name).getPropertyValues());
        }
    }

    @Test
    public void fun1() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(factory);
        reader.loadBeanDefinitions("classpath:bean.properties");
        String[] names = factory.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name + "-->" + factory.getBean(name));
        }
    }

    @Test
    public void fun2() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(factory);
        reader.register(ServiceA.class, ServiceB.class,ServiceC.class);
        factory.getBeansOfType(BeanPostProcessor.class).values().forEach(factory::addBeanPostProcessor);
        String[] names = factory.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name + "-->" + factory.getBean(name));
        }
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceB.class);
    }

    @Test
    public void fun3() {
//        DefaultListableBeanFactory registryFactory = new DefaultListableBeanFactory();
//        registryFactory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
//
//            @Override
//            public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//                if (beanClass.isAssignableFrom(ServiceB.class)) {
//                    ServiceB serviceB = new ServiceB();
//                    serviceB.setName("王五");
//                    return serviceB;
//                }
//                return null;
//            }
//        });
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceA.class);
    }
}
