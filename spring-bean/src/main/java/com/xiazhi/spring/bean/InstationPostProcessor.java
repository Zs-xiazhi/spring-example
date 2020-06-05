package com.xiazhi.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;

import java.lang.reflect.Constructor;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/31
 **/
public class InstationPostProcessor implements SmartInstantiationAwareBeanPostProcessor {


    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        if (beanClass.isAssignableFrom(ServiceB.class)) {
            System.out.println("调用构造器");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("类实例化之后");

        return false;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("类实例化之前===");
        return null;
    }
}
