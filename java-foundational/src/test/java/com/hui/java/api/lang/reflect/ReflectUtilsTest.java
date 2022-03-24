package com.hui.java.api.lang.reflect;

import com.hui.java.jdk.feature.java5.annotation.OrderHandler;
import org.testng.annotations.Test;


/**
 * 反射工具类的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/24 20:24
 * @since JDK8
 */

public class ReflectUtilsTest {

    @Test
    public void testReflectUtilsMockTest(){
        ReflectUtils.mockTest(OrderHandler.class);
    }
}
