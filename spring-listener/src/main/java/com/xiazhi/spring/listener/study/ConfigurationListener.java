package com.xiazhi.spring.listener.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author 赵帅
 * @data 2020/6/4
 */
@Configuration
public class ConfigurationListener {

    @Bean
    @Autowired(required = false)
    public EventMulticaster eventMulticaster(List<EventListener> eventListeners) {
        SimpleEventMulticaster multicaster = new SimpleEventMulticaster();
        eventListeners.forEach(multicaster::addEventListener);
        return multicaster;
    }
}
