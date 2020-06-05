package com.xiazhi.spring.listener.study;

import lombok.Data;

/**
 * 抽象事件对象
 * @author 赵帅
 * @data 2020/6/4
 */
@Data
public class AbstractEvent {

    /** 事件源对象 */
    private Object source;

    public AbstractEvent(Object source) {
        this.source = source;
    }
}
