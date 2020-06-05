package com.xiazhi.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/28
 **/
public class TestDemo {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        创建被代理类对象
//        Class<IService> proxyClass = (Class<IService>) Proxy.getProxyClass(IService.class.getClassLoader(), IService.class);
//        InvocationHandler handler = (x, y, z) -> {System.out.println("调用方法"); return null;};
//        IService service = proxyClass.getConstructor(InvocationHandler.class).newInstance(handler);
//        service.m1();
//        service.m2();
//        service.m3();

        IService service = (IService) Proxy.newProxyInstance(ServiceA.class.getClassLoader(), new Class[]{IService.class}, new JdkProxy(new ServiceA()));
        service.m2();
    }
}
