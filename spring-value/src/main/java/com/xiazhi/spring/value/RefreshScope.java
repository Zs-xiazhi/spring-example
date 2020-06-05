package com.xiazhi.spring.value;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ZhaoShuai
 * @date Create in 2020/6/3
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Scope(MyScope.REFRESH_SCOPE)
public @interface RefreshScope {

    ScopedProxyMode proxyMode() default ScopedProxyMode.TARGET_CLASS;

}
