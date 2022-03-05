package com.hui.java.api.util;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * ArrayUtilTest测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/13 21:21
 * @since JDK8
 */

public class ArrayUtilTest {


    @Test
    public void testGeneratorArray(){
        int[] numbers = ArrayUtil.generatorArray(10);
        System.out.println(Arrays.toString(numbers));
    }


}
