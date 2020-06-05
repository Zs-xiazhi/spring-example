package com.xiazhi.spring.listener.study;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 赵帅
 * @data 2020/6/4
 */
public class SimpleEventMulticaster implements EventMulticaster {

    private ConcurrentHashMap<String, List<EventListener>> beanListeners = new ConcurrentHashMap<>();


    @Override
    public  void addEventListener(EventListener eventListener) {
        String name = getEventSourceName(eventListener);
        Optional.ofNullable(beanListeners.get(name))
                .orElseGet(() -> {
                    List<EventListener> list = new ArrayList<>();
                    beanListeners.put(name, list);
                    return list;
                }).add(eventListener);
    }

    @Override
    public void removeListener(EventListener eventListener) {

    }

    @Override
    public void multicastEvent(AbstractEvent event) {
        String name = event.getClass().getName();
        Optional.ofNullable(beanListeners.get(name)).ifPresent(f ->{
            for (EventListener eventListener : f) {
                eventListener.doEvent(event);
            }
        });
    }

    private String getEventSourceName(EventListener eventListener) {
        ParameterizedType parameterizedType = (ParameterizedType) eventListener.getClass().getGenericInterfaces()[0];
        Type sourceType = parameterizedType.getActualTypeArguments()[0];
        return sourceType.getTypeName();
    }
}
