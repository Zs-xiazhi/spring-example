package com.xiazhi.spring.listener.study;

/**
 * @author 赵帅
 * @data 2020/6/4
 */
public interface EventListener<E extends AbstractEvent> {

    /**
     * 触发事件
     * @param e
     */
    void doEvent(E e);
}
