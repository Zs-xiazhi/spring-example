package com.xiazhi.spring.value;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author ZhaoShuai
 * @date Create in 2020/6/3
 **/
public class DbUtils {

    public static Map<String, Object> getDbInfo() {
        Map<String, Object> map = new HashMap<>(16);
        map.put("jdbc.username", "lisi");
        map.put("jdbc.password", "root");
        map.put("jdbc.url", UUID.randomUUID().toString());
        return map;
    }

    public static void clean(AbstractApplicationContext applicationContext) {
        Map<String, Object> dbInfo = getDbInfo();
        MapPropertySource mapPropertySource = new MapPropertySource("jdbc", dbInfo);
        applicationContext.getEnvironment().getPropertySources().addFirst(mapPropertySource);

        MyScope.clean();
    }
}
