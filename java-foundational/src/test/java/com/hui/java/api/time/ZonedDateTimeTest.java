package com.hui.java.api.time;

import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.TreeSet;

/**
 * 带时区的日期时间API常用方法测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/4 15:53
 * @since JDK8
 */

public class ZonedDateTimeTest {

    @Test
    public void testGetZoneInfo(){
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();

        TreeSet<String> availableZoneIdsTreeSet = new TreeSet<>(availableZoneIds);
        availableZoneIdsTreeSet.forEach(System.out::println);



        ZoneId defaultZoneId = ZoneId.systemDefault();
        System.out.println("系统的默认时区是："+defaultZoneId);
    }

    @Test
    public void testZonedDateTimeGetInstance(){
        ZonedDateTime defaultZoneDateTime = ZonedDateTime.now();
        System.out.println("系统默认时区的日期时间信息："+defaultZoneDateTime);
        ZoneId chongqingZoneId = ZoneId.of("Asia/Chongqing");
        ZonedDateTime chongqingZonedDateTime = ZonedDateTime.now(chongqingZoneId);
        System.out.println("亚洲/重庆时区的日期信息："+chongqingZonedDateTime);

        LocalDateTime currentDateTime = LocalDateTime.now();
        ZonedDateTime of = ZonedDateTime.of(currentDateTime, chongqingZoneId);
        System.out.println("将当前日期时间包装成亚洲/重庆时区的日期时间："+of);
    }

}
