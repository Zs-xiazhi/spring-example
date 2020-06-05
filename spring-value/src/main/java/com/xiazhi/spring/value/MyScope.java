package com.xiazhi.spring.value;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ZhaoShuai
 * @date Create in 2020/6/3
 **/
public class MyScope implements Scope {

    public static final String REFRESH_SCOPE = "refresh";

    public static final MyScope INSTANCE = new MyScope();

    private final ConcurrentHashMap<String, Object> beanMap = new ConcurrentHashMap<>();
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object bean = beanMap.get(name);
        if (bean == null) {
            bean = objectFactory.getObject();
            beanMap.put(name, bean);
        }
        return objectFactory.getObject();
    }

    public static final void clean() {
        INSTANCE.beanMap.clear();
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
