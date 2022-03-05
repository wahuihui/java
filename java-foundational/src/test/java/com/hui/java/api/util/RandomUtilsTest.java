package com.hui.java.api.util;

import org.testng.annotations.Test;

/**
 * 随机数工具类的测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/13 17:11
 * @since JDK8
 */

public class RandomUtilsTest {

    /**
     * 生成指定位数验证码(随机数)
     */
    @Test
    public void testVerificationCode(){
        for (int i = 0; i < 10; i++) {
            System.out.print(RandomUtils.verificationCode(6)+"\t");
        }
    }

    @Test
    public void testRandomPassword(){
        for (int i = 0; i < 10; i++) {
            System.out.println(RandomUtils.randomPassword(12));
        }
    }

}
