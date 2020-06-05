package com.xiazhi.spring;

import org.springframework.beans.factory.annotation.Lookup;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/28
 **/
public class ServiceB {

    private ServiceA serviceA;

    public void say() {
        ServiceA serviceA = this.getServiceA();
        System.out.println(serviceA);
    }

    public ServiceA getServiceA() {
        return null;
    }
}
