package com.xiazhi.spring.service;

import com.xiazhi.spring.dao.MyServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZhaoShuai
 * @date Create in 2020/6/3
 **/
@Service
public class MyService {
    @Autowired
    private MyServiceDao myServiceDao;

    public String test() {
        return myServiceDao.test();
    }
}
