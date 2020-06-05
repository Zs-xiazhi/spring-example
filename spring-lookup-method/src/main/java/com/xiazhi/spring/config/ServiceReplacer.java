package com.xiazhi.spring.config;

import com.xiazhi.spring.ServiceA;
import javafx.application.Application;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Method;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/28
 **/
public class ServiceReplacer implements MethodReplacer, ApplicationContextAware {

    private ApplicationContext applicationContext;
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        return this.applicationContext.getBean(ServiceA.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
