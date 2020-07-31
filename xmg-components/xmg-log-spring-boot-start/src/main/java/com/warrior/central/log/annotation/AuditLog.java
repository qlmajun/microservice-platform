package com.warrior.central.log.annotation;

import java.lang.annotation.*;

/**
 * @author majun
 * @description 自定义审计日志注解
 * @date 2020/6/12
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuditLog {

    /***
     *操作信息
     */
    String operation();
}
