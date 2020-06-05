package com.xiazhi.spring.lazy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/28
 **/
public class DemoTest {

    public static void main(String[] args) {
        System.out.println("spring容器初始化");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        System.out.println("spring容器初始化完毕");

            System.out.println(context.getBean(ServiceA.class));
            System.out.println(context.getBean(ServiceA.class));
            System.out.println(context.getBean(ServiceA.class));

    }
}
