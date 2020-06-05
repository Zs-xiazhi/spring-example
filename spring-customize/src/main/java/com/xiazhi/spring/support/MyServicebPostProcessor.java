package com.xiazhi.spring.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;

/**
 * @author 赵帅
 * @data 2020/6/5
 */
public class MyServicebPostProcessor implements BeanDefinitionRegistryPostProcessor , PriorityOrdered {
    public MyServicebPostProcessor() {
        System.out.println("实例化ServiceB");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("ServiceB呗调用BeanFactory");
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("ServiceB呗调用BeanDefinitionRegistry");
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
