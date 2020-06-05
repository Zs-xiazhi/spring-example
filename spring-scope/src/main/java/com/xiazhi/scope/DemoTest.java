package com.xiazhi.scope;

import com.xiazhi.scope.web.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/26
 **/
public class DemoTest {
    public static void main(String[] args) {
        Model model = new Model();
        Map<String, Object> map = new HashMap<>();
        model.say(map);
    }
}
