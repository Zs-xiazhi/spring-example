package com.xiazhi.scan;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/28
 **/
public class TestConfig {

    @Test
    public void fun1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanDemo.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name + "-->" + context.getBean(name));
        }
    }
}
