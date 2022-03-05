package com.hui.java.api.time;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoField;

/**
 * LocalDate类的测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/3 21:34
 * @since JDK8
 */

public class LocalDateTest {

    LocalDate now = LocalDate.now();

    @BeforeClass
    public void initLocalDate(){
        System.out.println("当前的日期信息："+now);
    }

    /**
     * 获取LocalDate对象的两种方式
     */
    @Test
    public void testLocalDateInstance(){
        LocalDate now = LocalDate.now();
        System.out.println("当前的日期信息："+now);

        LocalDate currentDate = LocalDate.of(2022,3,3);
        System.out.println("当前的日期信息："+currentDate);
    }

    /**
     * 通过LocalDate获取日期相关的信息
     */
    @Test
    public void testLocalDateGetDateInfo(){
        int year = now.getYear();
        Month month = now.getMonth();
        int dayOfMonth = now.getDayOfMonth();

        System.out.println("当前的日期信息："+year+"年"+month.getValue()+"月"+dayOfMonth+"日");

        boolean leapYear = now.isLeapYear();
        System.out.println("今年是否是闰年："+leapYear);

        LocalDate customDate = LocalDate.of(2020, 1, 1);
        System.out.println("2020年是否是闰年："+customDate.isLeapYear());

        System.out.println("今年有"+now.lengthOfYear()+"天");
        System.out.println("这个月有"+now.lengthOfMonth()+"天");

        System.out.println("今天是这周的第"+now.getDayOfWeek().getValue()+"天");
        System.out.println("今天是这月的第"+now.getDayOfMonth()+"天");
        System.out.println("今天是今年的第"+now.getDayOfYear()+"天");
    }

    /**
     * LocalDate的日期的修改
     */
    @Test
    public void testLocalDateUpdate(){
        LocalDate withYearDate = now.withYear(1999);
        System.out.println("将当前日期的年份改成1999年后的日期信息："+withYearDate);

        LocalDate withMonthDate = now.withMonth(4);
        System.out.println("将当前日期的月份改成4月后的日期信息："+withMonthDate);

        LocalDate withDayOfMonthDate = now.withDayOfMonth(7);
        System.out.println("将当前日期的日期改成7号后的日期信息："+withDayOfMonthDate);

        //链式编程 (之前StringBuilder的append()) 将当前日期改成1999年4月7号
        LocalDate finalDate = now.withYear(1999).withMonth(4).withDayOfMonth(7);
        System.out.println("将日期改成1999年4月7号的日期信息："+finalDate);

        System.out.println("修改当前日期年份为2019后的日期信息：" + now.with(ChronoField.YEAR, 2019));
    }


    /**
     * 日期的算术运算
     */
    @Test
    public void testLocalDatePlusMinus(){

        //日期加法
        LocalDate oneYearAfterDate = now.plusYears(1);
        System.out.println("一年后的日期信息："+oneYearAfterDate);

        LocalDate oneMonthAfterDate = now.plusMonths(1);
        System.out.println("一月后的日期信息："+oneMonthAfterDate);

        LocalDate oneDaysAfterDate = now.plusDays(1);
        System.out.println("一天后的日期信息："+oneDaysAfterDate);

        //日期减法
        LocalDate oneYearBeforeDate = now.minusYears(1);
        System.out.println("一年前的日期信息："+oneYearBeforeDate);

        LocalDate oneMonthBeforeDate = now.minusMonths(1);
        System.out.println("一月前的日期信息："+oneMonthBeforeDate);

        LocalDate oneDaysBeforeDate = now.minusDays(1);
        System.out.println("一天前的日期信息："+oneDaysBeforeDate);
    }


    /**
     * 日期的判断
     */
    @Test
    public void testLocalDateIsBeforeIsAfter(){
        //日期加法
        LocalDate oneYearAfterDate = now.plusYears(1);
        System.out.println("一年后的日期信息："+oneYearAfterDate);

        boolean before = now.isBefore(oneYearAfterDate);
        System.out.println("当前日期是否在一年以后的日期之前："+before);

        boolean after = now.isAfter(oneYearAfterDate);
        System.out.println("当前日期是否在一年以前的日期之前："+after);
    }







}
