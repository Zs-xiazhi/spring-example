package com.xiazhi.spring;

import com.xiazhi.spring.support.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @author 赵帅
 * @data 2020/6/5
 */
@ComponentScan
@Import({MyServiceAPostProcessor.class, MyServiceEPostProcessor.class,
        MyServiceCPostProcessor.class, MyServiceDPostProcessor.class, MyServicebPostProcessor.class})
public class MyScan {
}
