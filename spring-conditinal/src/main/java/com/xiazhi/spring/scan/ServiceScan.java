package com.xiazhi.spring.scan;

import com.xiazhi.spring.MyConditional;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/29
 **/
@Conditional(MyConditional.class)
@ComponentScan
public class ServiceScan {
}
