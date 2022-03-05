package com.hui.java.api.time.format;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author hui 1154437939@qq.com
 * @version 2022/3/4 14:48
 * @since JDK8
 */

public class DateTimeFormatterTest {

    LocalDate currentDate = LocalDate.now();
    LocalTime currentTime = LocalTime.now();

    LocalDateTime currentDateTime = LocalDateTime.now();


    @Test
    public void testLocalDateTimeFormat(){
        System.out.println("标准日期格式格式化日期后的日期信息："+currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println("标准日期格式格式化日期后的日期信息："+currentDate.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")));
        System.out.println("标准时间格式格式化时间后的时间信息："+currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss.SS")));
        System.out.println("标准时间格式格式化时间后的时间信息："+currentTime.format(DateTimeFormatter.ofPattern("HH时mm分ss秒SS")));
        System.out.println("标准日期时间格式格式化后的日期时间信息："+currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
        System.out.println("标准日期时间格式格式化后的日期时间信息："+currentDateTime.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒")));
    }

    @Test
    public void testLocalDateTimeParse(){
        System.out.println("日期字符串转化为LocalDate对象后的日期信息："+LocalDate.parse("2022-03-04"));
        DateTimeFormatter customDatePattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        System.out.println("日期字符串转化为LocalDate对象后的日期信息："+LocalDate.parse("2022年03月04日",customDatePattern));

        System.out.println("日期字符串转化为LocalTime对象后的日期信息："+LocalTime.parse("15:11:02.62"));
        DateTimeFormatter customTimePattern = DateTimeFormatter.ofPattern("HH时mm分ss秒SS");
        System.out.println("日期字符串转化为LocalTime对象后的日期信息："+LocalTime.parse("15时11分02秒62",customTimePattern));

        System.out.println("日期字符串转化为LocalDateTime对象后的日期信息："+LocalDateTime.parse("2022-03-04T15:29:07"));
        DateTimeFormatter customDateTimePattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println("日期字符串转化为LocalDateTime对象后的日期信息："+LocalDateTime.parse("2022年03月04日 15时29分07秒",customDateTimePattern));

    }

}
