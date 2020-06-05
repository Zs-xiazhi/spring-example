package com.xiazhi.spring.configuration;

import com.xiazhi.spring.configuration.config.Config;
import com.xiazhi.spring.configuration.config.DemoConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/28
 **/
public class DemoTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name + "->:" + context.getBean(name));
        }
    }
}
