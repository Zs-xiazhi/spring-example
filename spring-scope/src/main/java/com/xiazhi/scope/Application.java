package com.xiazhi.scope;

import com.xiazhi.scope.config.ThreadScopeBeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/25
 **/
@SpringBootApplication
@Import(ThreadScopeBeanPostProcessor.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
