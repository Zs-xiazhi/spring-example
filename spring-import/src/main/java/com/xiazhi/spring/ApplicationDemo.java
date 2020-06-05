package com.xiazhi.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/29
 **/
public class ApplicationDemo {

    @Test
    public void fun1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportConfig.class);
//        for (String name : context.getBeanDefinitionNames()) {
//            System.out.println(name + "->" + context.getBean(name));
//        }
        ServiceA serviceA = context.getBean(ServiceA.class);
        ServiceB serviceB = context.getBean(ServiceB.class);
        serviceA.m1();
        serviceB.m2();

    }
}
