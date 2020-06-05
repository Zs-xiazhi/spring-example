package com.xiazhi.scope.web;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/25
 **/
@RestController
public class HelloController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @RequestMapping("/hello")
    public String say() {
        System.out.println(applicationContext.getBean(Model.class));
        System.out.println(applicationContext.getBean(Model.class));
        System.out.println(applicationContext.getBean(Model.class));
        return "hello";
    }

    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
