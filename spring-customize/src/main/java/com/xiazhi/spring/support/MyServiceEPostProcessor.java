package com.xiazhi.spring.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author 赵帅
 * @data 2020/6/5
 */
@Order(1)
public class MyServiceEPostProcessor implements BeanDefinitionRegistryPostProcessor {
    public MyServiceEPostProcessor() {
        System.out.println("实例化ServiceE");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("ServiceE呗调用BeanFactory");
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("ServiceE呗调用BeanDefinitionRegistry");
    }
}
