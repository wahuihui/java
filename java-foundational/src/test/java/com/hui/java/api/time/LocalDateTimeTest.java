package com.hui.java.api.time;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * LocalDateTime类的常用方法的测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/4 14:38
 * @since JDK8
 */

public class LocalDateTimeTest {

    @Test
    public void testLocalDateTimeInstance(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前日期时间信息："+now);
        LocalDateTime customDateTime = LocalDateTime.of(2022, 3, 4, 14, 41, 0);
        System.out.println("自定义的时间信息："+customDateTime);
        LocalDateTime currentDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("当前日期时间信息："+currentDateTime);
    }

    @Test
    public void testLocalDateTimeGetLocalDateLocalTime(){
        LocalDateTime now = LocalDateTime.now();

        LocalDate nowDate = now.toLocalDate();
        LocalTime nowTime = now.toLocalTime();
        System.out.println("当前的日期信息："+nowDate);
        System.out.println("当前的时间信息："+nowTime);
    }

}
