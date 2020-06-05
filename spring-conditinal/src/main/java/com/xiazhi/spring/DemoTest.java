package com.xiazhi.spring;

import com.xiazhi.spring.config.AppConfig;
import com.xiazhi.spring.scan.ServiceScan;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/29
 **/
public class DemoTest {

    @Test
    public void fun1() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ServiceScan.class, AppConfig.class);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name + "->" + context.getBean(name));
        }
    }
}
