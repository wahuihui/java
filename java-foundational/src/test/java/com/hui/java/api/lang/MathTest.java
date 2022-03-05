package com.hui.java.api.lang;

import org.testng.annotations.Test;

/**
 * Math类的常用方法的测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/15 15:37
 * @since JDK8
 */

public class MathTest {

    @Test
    public void testMath(){
        //abs  绝对值
        System.out.println(Math.abs(5));
        System.out.println(Math.abs(-5));
        // 向上取整
        System.out.println(Math.ceil(3.14));
        //向下取整
        System.out.println(Math.floor(3.14));
        //四舍五入
        System.out.println(Math.round(3.4));
        System.out.println(Math.round(3.5));
        // 次幂
        System.out.println(Math.pow(2.0, 5.0));
    }

    //找出-10.8到5.9之间，绝对值大于6或者小于2.1的整数有多少个
    @Test
    public void testMathabs(){

        double min = -10.8;
        double max = 5.9;

        int count = 0;

        for (double i = Math.ceil(min); i < max; i++) {
            double abs = Math.abs(i);
            if (abs>6||abs<2.1){
                System.out.print(i+" ");
                count++;
            }
        }
        System.out.println("\n"+"范围内的整数共有："+count);

    }


}
