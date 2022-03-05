package com.hui.java.api.testng;

import org.testng.annotations.*;

/**
 * TestNG的使用测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/13 14:55
 * @since JDK8
 */

public class MyTest {



    @Test
    public void testTestAnnotation(){
        System.out.println("执行testTestAnnotation方法");
    }

    @BeforeMethod
    public void testBeforeMethodAnnotation(){
        System.out.println("执行testBeforeMethodAnnotation方法");
    }

    @AfterMethod
    public void testAfterMethodAnnotation(){
        System.out.println("执行testAfterMethodAnnotation方法");
    }

    @BeforeClass
    public void testBeforeClassAnnotation(){
        System.out.println("执行testBeforeClassAnnotation方法");
    }

    @AfterClass
    public void testAfterClassAnnotation(){
        System.out.println("执行testAfterClassAnnotation方法");
    }

}
