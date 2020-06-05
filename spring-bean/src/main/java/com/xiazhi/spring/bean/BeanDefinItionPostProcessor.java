package com.xiazhi.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/31
 **/
public class BeanDefinItionPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ServiceB) {
            System.out.println("Bean：" + beanName + "初始化化前调用");
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ServiceB) {
            System.out.println("Bean" + beanName + "初始化化后调用");
        }
        return null;
    }
}
