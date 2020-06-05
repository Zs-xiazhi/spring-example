package com.xiazhi.spring.controller;

import com.xiazhi.spring.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author ZhaoShuai
 * @date Create in 2020/6/3
 **/
@Controller
public class MyController {

    @Autowired
    private MyService myService;

    public String test() {
        return myService.test();
    }
}
