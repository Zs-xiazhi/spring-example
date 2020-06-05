package com.xiazhi.spring.lazy;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/28
 **/
public class ServiceA {

    private String name;

    public ServiceA() {
        System.out.println("初始化serviceA");
        System.out.println(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
