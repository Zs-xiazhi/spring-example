package com.xiazhi.spring.dependon;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/26
 **/
@Component
@DependsOn({"serviceC", "serviceB"})
public class ServiceA implements DisposableBean {

    public ServiceA() {
        System.out.println("创建A");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁对象ServiceA");
    }
}
