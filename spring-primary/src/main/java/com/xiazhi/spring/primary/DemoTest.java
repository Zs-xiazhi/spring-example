package com.xiazhi.spring.primary;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/28
 **/
public class DemoTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
//        IService bean = context.getBean(IService.class);
        NormalBean bean1 = context.getBean(NormalBean.class);
        List<IService> service = bean1.getService();
        System.out.println(service);
//        System.out.println(bean);
    }
}
