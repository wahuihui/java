package com.hui.java.api.util;

import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Random类的测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/13 16:49
 * @since JDK8
 */

public class RandomTest {

    @Test
    public void testRandom() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            //随机生成int范围内的随机数
            System.out.print(random.nextInt() + " ");
        }
    }


    @Test
    public void testRandomBound() {
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            //生成0~29的随机数
            System.out.print(random.nextInt(30) + "  ");
        }
    }

    @Test
    public void testThreadLocalRandom() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for (int i = 0; i < 10; i++) {
            System.out.println(threadLocalRandom.nextDouble(50.0));
        }
    }



}
