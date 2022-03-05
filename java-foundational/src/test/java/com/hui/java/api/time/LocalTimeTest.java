package com.hui.java.api.time;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalTime;

/**
 * Java8时间API-LocalTime类的常用方法的测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/4 14:13
 * @since JDK8
 */

public class LocalTimeTest {

    LocalTime now = null;

    @BeforeClass
    public void initLocalTime(){
        now = LocalTime.now();
        System.out.println("当前的时间信息："+now);
    }

    /**
     * 两种创建LocalTime对象的方法
     */
    @Test
    public void testLocalTimeInstance(){
        LocalTime now = LocalTime.now();
        System.out.println("当前的时间信息："+now);

        LocalTime customTime = LocalTime.of(14,18,56);
        System.out.println("当前的时间信息："+customTime);
    }

    @Test
    public void testLocalTimeGetTimeInfo(){
        System.out.println("当前的时间信息："+now.getHour()+"时"+now.getMinute()+"分"+now.getSecond()+"秒"+now.getNano()+"毫秒");
    }

    @Test
    public void testLocalTimeUpdateTime(){
        LocalTime withOneHour = now.withHour(1);
        System.out.println("当前时间的小时改成1点时的时间信息："+withOneHour);
        LocalTime withOneMinute = now.withMinute(1);
        System.out.println("当前时间的分钟改成1分时的时间信息："+withOneMinute);
        LocalTime withOneSecond = now.withSecond(1);
        System.out.println("当前时间的小时改成1秒时的时间信息："+withOneSecond);

        LocalTime withTime = now.withHour(1).withMinute(1).withSecond(1);
        System.out.println("当前时间改为1时1分1秒后的时间信息："+withTime);
    }

    @Test
    public void testLocalTimeIsBeforeIsAfter(){
        LocalTime withOneHour = now.withHour(1);
        System.out.println("当前时间的小时改成1点时的时间信息："+withOneHour);

        System.out.println("当前时间在1点之前："+now.isBefore(withOneHour));
        System.out.println("当前时间在1点之后："+now.isAfter(withOneHour));
    }


    @Test
    public void testLocalTimePlusMinus(){
        System.out.println("当前时间增加1小时后的时间信息："+now.plusHours(1));
        System.out.println("当前时间减少1小时后的时间信息："+now.minusHours(1));
        System.out.println("当前时间增加10分钟后的时间信息："+now.plusMinutes(10));
        System.out.println("当前时间减少10分钟后的时间信息："+now.minusMinutes(10));
    }

}
