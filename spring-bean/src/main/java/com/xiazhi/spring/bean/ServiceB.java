package com.xiazhi.spring.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/31
 **/
@Component("serviceBBB")
@Data
public class ServiceB extends ServiceA{

    private Integer age;
}
