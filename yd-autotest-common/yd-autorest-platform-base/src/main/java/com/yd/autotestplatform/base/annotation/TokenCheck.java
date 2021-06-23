package com.yd.autotestplatform.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 *
 * </p>
 *
 * @author: yd
 * @version: V1.0
 * @contact:
 * @date: 2021-06-23 14:18
 * @Email: 664720125@qq.com
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenCheck {
    // 默认需要校验token
    boolean required() default true;
}
