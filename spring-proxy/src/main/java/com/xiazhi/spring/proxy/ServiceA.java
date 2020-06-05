package com.xiazhi.spring.proxy;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/28
 **/
public class ServiceA implements IService{
    @Override
    public void m1() {
        System.out.println("m1");
    }

    @Override
    public void m2() {
        System.out.println("m2 ServiceA");
    }

    @Override
    public void m3() {
        System.out.println("m3");
    }
}
