package com.xiazhi.spring.listener.study;

import org.springframework.stereotype.Component;

/**
 * @author 赵帅
 * @data 2020/6/4
 */
@Component
public class SendEmailListener implements EventListener<UserRegisterSuccessEvent> {

    @Override
    public void doEvent(UserRegisterSuccessEvent e) {
        System.out.println(String.format("发送邮件[%s]", e.getUsername()));
    }
}
