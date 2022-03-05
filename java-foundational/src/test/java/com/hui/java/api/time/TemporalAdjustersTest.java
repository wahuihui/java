package com.hui.java.api.time;

import org.testng.annotations.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * 查找并修改成特殊的日期API测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/4 16:16
 * @since JDK8
 */

public class TemporalAdjustersTest {

    /**
     * 测试TemporalAdjusters的常用方法
     */
    @Test
    public void testTemporalAdjusters(){

        LocalDate currentDate = LocalDate.now();
        System.out.println("获取本月的第一天："+currentDate.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("获取今年的第一天："+currentDate.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println("获取本月的最后一天："+currentDate.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("获取本月的第三个星期天："+currentDate.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.SUNDAY)));
        System.out.println("获取下一个周一的日期："+currentDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)));
    }

}
