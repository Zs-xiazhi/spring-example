package com.xiazhi.spring.proxy;

import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * Cglib通过为当前类（非final）生成一个子类并覆盖当前类来实现代理
 * 会拦截类的所有（非final）方法进行代理
 * @author ZhaoShuai
 * @date Create in 2020/5/28
 **/
public class CglibProxy {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ServiceB.class);
//        enhancer.setCallback(new MethodInterceptor() {
//            @Override
//            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//
//                System.out.println("调用方法：" + method.getName());
//                Object o1 = methodProxy.invokeSuper(o, objects);
//                return o1;
//            }
//        });
//        enhancer.setCallback((FixedValue) () -> "hello");
//        enhancer.setCallback(NoOp.INSTANCE);
        Callback[] calls = {(FixedValue) () ->{
            System.out.println("返回固定值");
            return "hello";
        },
                (MethodInterceptor) (o, method, objects, proxy) -> proxy.invokeSuper(o, objects)};

        enhancer.setCallbacks(calls);
        enhancer.setCallbackFilter((m) -> m.getName().startsWith("get") ? 0 : 1);
        ServiceB serviceB = (ServiceB) enhancer.create();
        serviceB.getA();
        serviceB.getB();
        serviceB.fun1();
        serviceB.fun2();
    }
}
