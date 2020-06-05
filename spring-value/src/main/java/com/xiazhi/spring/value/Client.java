package com.xiazhi.spring.value;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ZhaoShuai
 * @date Create in 2020/6/3
 **/
@Component
@Data
public class Client {

    @Autowired
    private JdbcTemplate jdbcTemplate;
}
