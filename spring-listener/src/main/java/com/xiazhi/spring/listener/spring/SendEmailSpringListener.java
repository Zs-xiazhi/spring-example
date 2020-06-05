package com.xiazhi.spring.listener.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author 赵帅
 * @data 2020/6/4
 */
@Component
public class SendEmailSpringListener implements ApplicationListener<RegisterEvent> {
    @Override
    public void onApplicationEvent(RegisterEvent event) {
        System.out.println(String.format("发送%s邮件", event.getUsername()));
    }
}
