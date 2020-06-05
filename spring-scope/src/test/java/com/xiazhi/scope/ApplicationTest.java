package com.xiazhi.scope;

import com.xiazhi.scope.config.MvcConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTest {

    @Test
    public void fun1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        MvcConfiguration bean = context.getBean(MvcConfiguration.class);
        System.out.println(bean);
    }

}