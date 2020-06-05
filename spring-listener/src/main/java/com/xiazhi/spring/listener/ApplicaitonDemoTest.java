package com.xiazhi.spring.listener;

import com.xiazhi.spring.listener.spring.Register;
import com.xiazhi.spring.listener.study.UserRegister;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ZhaoShuai
 * @date Create in 2020/6/4
 **/
public class ApplicaitonDemoTest {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanner.class);
        Register bean = context.getBean(Register.class);
        bean.register("zhangsan");

    }
}
