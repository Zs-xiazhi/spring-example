package com.xiazhi.series.factory;

import com.xiazhi.series.model.UserInfo;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/25
 **/
public class UserFactoryBean implements FactoryBean<UserInfo> {
    int count = 1;
    public UserInfo getObject() throws Exception {
        UserInfo userInfo = new UserInfo();
        System.out.println("BeanFactory" + count++ + "对象");
        return userInfo;
    }

    public Class<?> getObjectType() {
        return UserInfo.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
