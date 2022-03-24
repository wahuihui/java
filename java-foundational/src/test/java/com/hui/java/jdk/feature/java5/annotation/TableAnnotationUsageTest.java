package com.hui.java.jdk.feature.java5.annotation;

/**
 * 自定义注解的使用-带属性
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/24 20:28
 * @since JDK8
 */

public class TableAnnotationUsageTest {
}

@Table(id=1,name="employee",dataBases = "MySQL")
class Employee{

    @Column(name = "name")
    String name;
}
