package com.xiazhi.spring;

import com.xiazhi.spring.controller.MyController;
import com.xiazhi.spring.service.MyService;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhaoShuai
 * @date Create in 2020/6/3
 **/
public class ApplicationDemo {
    public static void main(String[] args) {
        ApplicationContext parentContext = new ClassPathXmlApplicationContext("classpath:application-parent.xml");
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:application-child.xml"}, parentContext);

        System.out.println(context.getBean(MyService.class));
        System.out.println(context.getBeansOfType(MyService.class));
        System.out.println(BeanFactoryUtils.beansOfTypeIncludingAncestors(context, MyService.class));
        System.out.println(parentContext.getBean(MyController.class));
    }
}
