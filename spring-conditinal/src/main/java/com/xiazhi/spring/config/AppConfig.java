package com.xiazhi.spring.config;

import com.xiazhi.spring.MyConditional;
import com.xiazhi.spring.scan.ServiceA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;


/**
 * @author ZhaoShuai
 * @date Create in 2020/5/29
 **/
@Configuration
public class AppConfig {

    @Bean
    public ServiceA service11() {
        return new ServiceA();
    }
}
