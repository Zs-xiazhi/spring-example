package com.xiazhi.scope.support;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/26
 **/
public class ThreadScope implements Scope {

    public static final String THREAD_SCOPE = "thread";
    private final ThreadLocal<Map<String, Object>> beanMap = ThreadLocal.withInitial(HashMap::new);

    /**
     * 返回当前作用域中name对应的bean对象
     * @param name 需要检索的bean名称
     * @param objectFactory  如果name对应的bean没有找到，可以调用这个objectFactory创建对象
     * @return bean对象
     */
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object bean = beanMap.get().get(name);
        if (Objects.isNull(bean)) {
            bean = objectFactory.getObject();
            beanMap.get().put(name, bean);
        }
        return bean;
    }

    /**
     * 将当前name对应的bean从当前作用域中移除
     *
     * @param name bean名称
     * @return 移除的bean对象
     */
    @Nullable
    @Override
    public Object remove(String name) {
        return this.beanMap.get().remove(name);
    }

    /**
     * 用于注册销毁回调，如果想要销毁相应的对象，则由spring容器注册相应的销毁回调，而由自定义作用域选择是不是要销毁相应的对象
     *
     * @param s name
     * @param runnable 进程
     */
    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {
        System.out.println("bean作用域结束，清理bean");
    }

    /**
     * 用于解析相应的上下文事件，比如request作用域将返回request中的属性
     *
     * @param s name
     * @return 对象
     */
    @Nullable
    @Override
    public Object resolveContextualObject(String s) {
        System.out.println("--------------------" + s);
        return null;
    }

    /**
     * 作用域的会话标识，比如session的标识是sessionId
     *
     * @return 线程名
     */
    @Nullable
    @Override
    public String getConversationId() {
        System.out.println(Thread.currentThread().getName() + "------------");
        return Thread.currentThread().getName();
    }

}
