package com.xiazhi.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/29
 **/
public class ServiceBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().getName().contains("Service")) {
            return this.createProxy(bean);
        }
        return bean;
    }

    private Object createProxy(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            long start = System.currentTimeMillis();
            Object result = method.invoke(target, objects);
            long end = System.currentTimeMillis();
            System.out.println(String.format("%s方法调用耗时%d", method.getName(), end - start));
            return result;
        });
        return enhancer.create();
    }
}
