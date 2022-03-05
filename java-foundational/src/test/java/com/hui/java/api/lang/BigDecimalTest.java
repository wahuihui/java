package com.hui.java.api.lang;

import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * BigDecimal类的常用方法测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/15 14:20
 * @since JDK8
 */

public class BigDecimalTest {

    @Test
    public void testBigDecimal(){
        //要想精度准确，要传入String类型的值
        BigDecimal value1 = new BigDecimal("-0.3");
        BigDecimal value2 = new BigDecimal("0.7");
        //绝对值
        BigDecimal abs = value1.abs();
        System.out.println(abs);
        //加
        BigDecimal add = value1.add(value2);
        System.out.printf("%s + %s = %s\n",value1,value2,add);
        //减
        BigDecimal subtract = value1.subtract(value2);
        System.out.printf("%s - %s = %s\n",value1,value2,subtract);
        //乘
        BigDecimal multiply = value1.multiply(value2);
        System.out.printf("%s * %s = %s\n",value1,value2,multiply);
        //除    scale:(value) value=? 表示保留几位小数  RoundingMode.HALF_UP 表示四舍五入
        BigDecimal divide = value1.divide(value2,2, RoundingMode.HALF_UP);
        System.out.printf("%s / %s = %s\n",value1,value2,divide);
        //比较两个BigDecimal  1.compareTo(2)  1>2返回1  1=2返回0  1<2返回-1
        System.out.println(value2.compareTo(value1));
        //相反数
        System.out.println(value1.negate());
    }
}
