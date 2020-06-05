package com.xiazhi.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * jdk代理只能对接口进行代理，对于没有实现接口的类，无法代理。
 * @author ZhaoShuai
 * @date Create in 2020/5/28
 **/
public class JdkProxy implements InvocationHandler {

    private Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass().getName());
        System.out.println(method.getName());
        System.out.println(args);
        System.out.println("调用代理方法");
        Object invoke = method.invoke(proxy, args);
        return invoke;
    }
}
