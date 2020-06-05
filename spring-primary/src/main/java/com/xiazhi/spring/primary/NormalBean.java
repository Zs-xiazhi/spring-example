package com.xiazhi.spring.primary;

import java.util.List;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/28
 **/
public class NormalBean {

    private List<IService> service;

    public void setService(List<IService> service) {
        this.service = service;
    }

    public List<IService> getService() {
        return service;
    }
}
