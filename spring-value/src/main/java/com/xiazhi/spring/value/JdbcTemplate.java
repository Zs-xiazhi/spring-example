package com.xiazhi.spring.value;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author ZhaoShuai
 * @date Create in 2020/6/3
 **/
@Data
@Component
@PropertySource("classpath:jdbc.properties")
@RefreshScope
public class JdbcTemplate {

    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password:123}")
    private String password;
    @Value("${jdbc.url}")
    private String url;

}
