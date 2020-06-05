package com.xiazhi.spring.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/30
 **/
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Data
@ComponentScan
@Import({MyBeanPostProcessor.class, BeanDefinItionPostProcessor.class, InstationPostProcessor.class})

public class ServiceA {

    @Autowired
    private ServiceC serviceC;

    private String name;
}
