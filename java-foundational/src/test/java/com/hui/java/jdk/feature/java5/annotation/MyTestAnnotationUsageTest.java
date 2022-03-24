package com.hui.java.jdk.feature.java5.annotation;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 自定义注解-不带属性 的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/24 20:26
 * @since JDK8
 */
//在类上使用
@MyTest("在类上使用")
public class MyTestAnnotationUsageTest {

    @MyTest("在构造函数上使用")
    MyTestAnnotationUsageTest(){}

    @MyTest("在方法上使用")
    public void showTime(@MyTest("在方法的形参使用") String str){

        String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(currentTime);
    }
}
