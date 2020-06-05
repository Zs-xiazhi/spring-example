package com.xiazhi.spring.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

/**
 * @author 赵帅
 * @data 2020/6/5
 */
public class MyServiceCPostProcessor implements BeanFactoryPostProcessor, Ordered, PriorityOrdered {
    public MyServiceCPostProcessor() {
        System.out.println("实例化ServiceC");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("ServiceC呗调用");
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
