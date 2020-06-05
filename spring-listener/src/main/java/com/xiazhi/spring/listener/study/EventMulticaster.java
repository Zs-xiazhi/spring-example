package com.xiazhi.spring.listener.study;

/**
 * 事件广播器
 * @author 赵帅
 * @data 2020/6/4
 */
public interface EventMulticaster {

    /**
     * 添加事件监听器
     * @param eventListener
     */
    void addEventListener(EventListener eventListener);

    /**
     * 移除事件监听器
     *
     * @param eventListener
     */
    void removeListener(EventListener eventListener);

    /**
     * 广播事件
     * @param event
     */
    void multicastEvent(AbstractEvent event);
}
