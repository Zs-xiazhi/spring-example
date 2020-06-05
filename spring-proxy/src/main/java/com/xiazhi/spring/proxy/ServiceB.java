package com.xiazhi.spring.proxy;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/28
 **/
public class ServiceB {

    public void fun1() {
        System.out.println(" fun1 call");
        this.fun2();
    }

    public void fun2() {
        System.out.println(" fun2 call");
    }

    public String getA() {
        return null;
    }

    public String getB() {
        return null;
    }

}
