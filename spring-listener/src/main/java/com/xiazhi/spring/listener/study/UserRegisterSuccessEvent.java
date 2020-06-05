package com.xiazhi.spring.listener.study;

import lombok.Data;

/**
 * 用户注册成功事件
 * @author 赵帅
 * @data 2020/6/4
 */
@Data
public class UserRegisterSuccessEvent extends AbstractEvent {

    private String username;

    public UserRegisterSuccessEvent(Object source, String username) {
        super(source);
        this.username = username;
    }
}
