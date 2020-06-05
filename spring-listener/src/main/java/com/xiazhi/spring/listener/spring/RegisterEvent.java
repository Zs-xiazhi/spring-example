package com.xiazhi.spring.listener.spring;

import lombok.Data;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author 赵帅
 * @data 2020/6/4
 */
@Getter
public class RegisterEvent extends ApplicationEvent {

    private String username;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public RegisterEvent(Object source, String username) {
        super(source);
        this.username = username;
    }
}
