package com.xiazhi.series;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/24
 **/
public class ApplicationContext {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
//        HelloWorld bean = context.getBean(HelloWorld.class);
//        bean.say();

//        String[] names = context.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name + ":" + context.getBean(name));
//        }

        System.out.println(context.getBean("userFactoryBean"));
        System.out.println(context.getBean("userFactoryBean"));
    }
}
