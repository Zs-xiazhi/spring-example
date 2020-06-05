package com.xiazhi.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 赵帅
 * @data 2020/6/5
 */
public class DemoTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyScan.class);
    }
}
