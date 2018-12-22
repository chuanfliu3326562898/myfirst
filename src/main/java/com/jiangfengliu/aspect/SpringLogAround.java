package com.jiangfengliu.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhaozhiliang
 * @create 2018-05-15 下午5:56
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SpringLogAround {
    /**
     * 接口名称
     */
    String interfaceName() default "";

    /**
     * 接口说明
     */
    String interfaceDesc() default "";
}
