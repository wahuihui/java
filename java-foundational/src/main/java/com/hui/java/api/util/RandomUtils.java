package com.hui.java.api.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机数工具类
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/13 17:02
 * @since JDK8
 */

public class RandomUtils {

    /**
     * 特殊字符
     */
    private static final String SPECIAL_CHARS = "!@#$%^&*";


    /**
     *
     * @return
     */
    private static Random random(){
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        return threadLocalRandom;
    }


    /**
     * 生成指定位数验证码(随机数)
     */
    public static String verificationCode(int length){
        char[] chars = new char[length];
        if (length==4 || length==6){
            for (int i = 0; i < length; i++) {
                chars[i] = (char)(random().nextInt(10)+48);
            }
        }else {
            throw new RuntimeException("验证码长度不合理!");
        }
        return new String(chars);
    }


    /**
     * 生成一个随机字符(大写字母、小写字母、数字以及特殊字符)
     * @param random
     * @return
     */
    private static char nextChar(Random random){
        switch (random.nextInt(4)){
            case 0:
                return (char)('0'+random.nextInt(10));
            case 1:
                return (char)('A'+random.nextInt(26));
            case 2:
                return (char)('a'+random.nextInt(26));
            default:
                return SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length()));
        }
    }


    /**
     * 随机密码
     * @param length
     * @return
     */
    public static String randomPassword(int length){
        if (length<6){
            throw new RuntimeException("密码长度太短，不安全！！！");
        }

        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = nextChar(random());
        }
        return new String(chars);
    }


    public static int[] randomArray(int length){
        int[] numbers = new int[length];

        for (int i = 0; i < length; i++) {
            numbers[i] = random().nextInt();
        }

        return numbers;
    }

}
