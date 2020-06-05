package com.xiazhi.spring.value;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.env.MapPropertySource;

import java.util.Map;

/**
 * @author ZhaoShuai
 * @date Create in 2020/6/3
 **/
@ComponentScan
public class ApplicationDemoTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationDemoTest.class);
        Client bean = context.getBean(Client.class);
        System.out.println(bean.getJdbcTemplate());
    }

    @Test
    public void fun1() {
        Map<String, Object> dbInfo = DbUtils.getDbInfo();
        MapPropertySource jdbc = new MapPropertySource("jdbc", dbInfo);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().getPropertySources()
                .addFirst(jdbc);
        context.register(ApplicationDemoTest.class);
        context.refresh();
        JdbcTemplate bean = context.getBean(JdbcTemplate.class);
        System.out.println(bean);
    }

    @Test
    public void fun2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getBeanFactory().registerScope(MyScope.REFRESH_SCOPE, MyScope.INSTANCE);
        Map<String, Object> dbInfo = DbUtils.getDbInfo();
        MapPropertySource jdbc = new MapPropertySource("jdbc", dbInfo);
        context.getEnvironment().getPropertySources()
                .addFirst(jdbc);
        context.register(ApplicationDemoTest.class);
        context.refresh();


        JdbcTemplate jdbcTemplate = context.getBean(Client.class).getJdbcTemplate();
        System.out.println(jdbcTemplate);
        DbUtils.clean(context);
        JdbcTemplate jdbcTemplate1 = context.getBean(Client.class).getJdbcTemplate();
        System.out.println(jdbcTemplate1);



    }
}
