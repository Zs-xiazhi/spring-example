package com.xiazhi.spring.dependon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/26
 **/
@ComponentScan
public class ApplicationDemo {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationDemo.class);
//        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
//            System.out.println(beanDefinitionName);
//        }
//        Object serviceB = context.getBean("serviceB");
//        System.out.println(serviceB);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
//        context.close();
    }
}
