package com.xiazhi.scope.web;

import com.xiazhi.scope.support.ThreadScope;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/25
 **/
@Component
public class Model extends AbstractModel {

    public Model() {
        System.out.println(String.format("%s线程创建实例：%s,scope:{%s}", Thread.currentThread().getName(), this, Model.class.getAnnotation(Scope.class).value()));
    }

    public void say(HashMap<String, Object> param) {
        System.out.println("child");
        System.out.println(param);
    }
}
