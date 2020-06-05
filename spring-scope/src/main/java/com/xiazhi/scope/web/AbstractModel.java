package com.xiazhi.scope.web;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/26
 **/
public class AbstractModel {

    public void say(Map<String, Object> param) {
        System.out.println("parent");
        System.out.println(param);
    }
}
