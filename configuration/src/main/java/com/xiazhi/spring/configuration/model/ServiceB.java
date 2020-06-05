package com.xiazhi.spring.configuration.model;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/28
 **/
public class ServiceB {

    private ServiceA serviceA;

    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
