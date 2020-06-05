package com.xiazhi.spring.listener.study;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 注册器
 * @author 赵帅
 */
@Data
@Component
public class UserRegister {

    @Autowired
    private EventMulticaster eventMulticaster;

    public void register(String username) {
        System.out.println(String.format("用户[%s]注册成功", username));
        this.eventMulticaster.multicastEvent(new UserRegisterSuccessEvent(this, username));
    }
}
