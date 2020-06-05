package com.xiazhi.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/28
 **/
public class DemoTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        ServiceB b = context.getBean(ServiceB.class);
        ServiceB b1 = context.getBean(ServiceB.class);
        System.out.println(b);
        System.out.println(b1);
        b.say();
        b.say();
        b.say();

    }
}
