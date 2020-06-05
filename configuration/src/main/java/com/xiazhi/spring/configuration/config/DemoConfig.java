package com.xiazhi.spring.configuration.config;

import com.xiazhi.spring.configuration.model.ServiceA;
import com.xiazhi.spring.configuration.model.ServiceB;
import com.xiazhi.spring.configuration.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/28
 **/
@Configuration
public class DemoConfig {

    @Bean
    public ServiceB serviceB(ServiceA serviceA) {
        System.out.println("serviceA:" + serviceA);
        return new ServiceB(serviceA);
    }

    @Bean
    public ServiceA serviceA(User user) {
        System.out.println("serviceUse:" + user);
        return new ServiceA(user);
    }

    @Bean
    public User user() {
        System.out.println("创建user对象");
        return new User();
    }

}
