package com.xiazhi.spring.dependon;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/26
 **/
@Component
public class ServiceB implements DisposableBean {

    public ServiceB() {
        System.out.println("创建B");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁对象ServiceB");
    }
}
