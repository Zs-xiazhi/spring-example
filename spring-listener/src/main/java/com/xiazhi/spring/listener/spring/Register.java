package com.xiazhi.spring.listener.spring;

import com.xiazhi.spring.listener.study.UserRegisterSuccessEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Component;

/**
 * @author 赵帅
 * @data 2020/6/4
 */
@Component
public class Register implements ApplicationEventPublisherAware {

    public ApplicationEventPublisher eventPublisher;

    public void register(String username) {
        System.out.println(String.format("用户[%s]注册成功", username));
        this.eventPublisher.publishEvent(new RegisterEvent(this, username));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
