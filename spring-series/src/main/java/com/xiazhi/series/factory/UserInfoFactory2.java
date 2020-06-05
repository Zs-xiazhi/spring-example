package com.xiazhi.series.factory;

import com.xiazhi.series.model.UserInfo;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/25
 **/
public class UserInfoFactory2 {

    public UserInfo userInfo1() {
        System.out.println("UserInfoFactory:userInfo1()");
        System.out.println("无参方法");
        return new UserInfo();
    }

    public UserInfo userInfo2(String username, String age) {
        System.out.println("UserInfoFactory:userInfo2()");
        System.out.println("有参构造");
        return new UserInfo(username, "20");
    }
}
