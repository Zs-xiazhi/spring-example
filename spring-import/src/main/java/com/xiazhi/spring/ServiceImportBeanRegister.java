package com.xiazhi.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/29
 **/
public class ServiceImportBeanRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        BeanDefinition definition = BeanDefinitionBuilder.genericBeanDefinition(ServiceA.class).getBeanDefinition();
        registry.registerBeanDefinition("serviceAAA", definition);
    }
}
