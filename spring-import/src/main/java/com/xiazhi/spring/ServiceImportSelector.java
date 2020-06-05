package com.xiazhi.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.reflect.Method;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/29
 **/
public class ServiceImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{ServiceBeanPostProcessor.class.getName(), ServiceA.class.getName(), ServiceB.class.getName()};
    }

}
