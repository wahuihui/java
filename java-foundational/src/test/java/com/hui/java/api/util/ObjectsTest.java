package com.hui.java.api.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

/**
 * Objects常用方法的测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/13 16:01
 * @since JDK8
 */

public class ObjectsTest {

    /**
     * 测试用String类的equals()方法，体会啥叫空指针异常
     * @see String#equals(Object) 
     */
    @Test
    public void testStringEquals(){
        String str1 = null;
        String str2 = "tony";
        System.out.println(str1.equals(str2));
    }

    /**
     * 测试用Objects类的equals()方法，体会如何解决空指针异常
     * @see java.util.Objects#equals(Object, Object) 
     */
    @Test
    public void testObjectsEquals(){
        String str1 = null;
        String str2 = "tony";
        boolean result = Objects.equals(str1,str2);
        Assert.assertEquals(result,false);
    }

    /**
     * 测试Objects类的nonNull()方法
     * @see Objects#nonNull(Object)
     */
    @Test
    public void testObjectsNonNull(){
        String str1 = null;
        Assert.assertEquals(Objects.nonNull(str1),false);

        str1 = "";
        Assert.assertEquals(Objects.nonNull(str1),true);
    }

    /**
     * 测试Objects类的requiredNonNull()方法
     * @see Objects#requireNonNull(Object)
     */
    @Test
    public void testObjectsRequiredNonNull(){

        String str = "tony";
        System.out.println(Objects.requireNonNull(str));

        str = null;
        System.out.println(Objects.requireNonNull(str));

    }

}
