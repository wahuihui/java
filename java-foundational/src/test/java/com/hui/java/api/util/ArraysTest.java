package com.hui.java.api.util;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Arrays常用方法测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/13 21:13
 * @since JDK8
 */

public class ArraysTest {


    @Test
    public void testArraysSort(){

        int[] numbers = ArrayUtil.generatorArray(10);
        System.out.println("排序前："+Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println("排序后："+Arrays.toString(numbers));
    }
}
