package com.hui.java.api.util;

/**
 * 自定义数组工具类
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/13 21:14
 * @since JDK8
 */

public class ArrayUtil {

    /**
     *
     * @param length
     * @return
     */
    public static int[] generatorArray(int length){
        if (length<1){
            throw new RuntimeException("数组长度非法！");
        }
        return RandomUtils.randomArray(length);
    }

}
