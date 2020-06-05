package com.xiazhi.scope.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/28
 **/
@Configuration
public class MvcConfiguration  {

    public MvcConfiguration() {
        System.out.println("调用构造方法创建对象");
        System.out.println(this);
    }
}
