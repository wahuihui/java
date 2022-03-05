package com.hui.java.api.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 断言使用的测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/13 15:38
 * @since JDK8
 */

public class AssertTest {

    @Test
    public void testAssert(){
        Assert.assertEquals(10,10);
    }


}
