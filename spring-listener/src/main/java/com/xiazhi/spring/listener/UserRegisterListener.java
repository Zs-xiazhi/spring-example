package com.xiazhi.spring.listener;

import com.xiazhi.spring.listener.spring.RegisterEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author 赵帅
 * @data 2020/6/4
 */
@Component
public class UserRegisterListener {

    @EventListener
    public void sendEmail(RegisterEvent event) {
        System.out.println("注解发送邮件");
    }
}
