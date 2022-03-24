package com.hui.java.jdk.feature.java5.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * 注解只能使用在方法上
 * @author hui 1154437939@qq.com
 * @version 2022/3/24 20:15
 * @since JDK8
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {

}
