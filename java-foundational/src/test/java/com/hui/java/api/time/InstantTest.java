package com.hui.java.api.time;

import org.testng.annotations.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 时间戳的常用方法测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/4 15:35
 * @since JDK8
 */

public class InstantTest {

    @Test
    public void testInstantGetInstance(){
        Instant currentInstant = Instant.now();
        //比当前系统时间晚了八小时
        System.out.println("当前时间戳（UTC时间）："+currentInstant);

        //1970-01-01T00:00:03Z 指的是不带时区的UTC时间
        Instant plusThreeSecondsInstant = Instant.ofEpochSecond(3);
        System.out.println("当前标准时间（UTC时间）加上3秒的时间戳："+plusThreeSecondsInstant);

        Instant plusThreeMillisInstant = Instant.ofEpochMilli(3);
        System.out.println("当前标准时间（UTC时间）加上3毫秒的时间戳："+plusThreeMillisInstant);
    }

    @Test
    public void testInstantZonedDateTime(){
        Instant currentInstant = Instant.now();
        ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime shanghaiZoneDateTime = currentInstant.atZone(shanghaiZoneId);
        System.out.println("亚洲/上海时区的日期时间信息："+shanghaiZoneDateTime);

        ZoneId tokyoZoneId = ZoneId.of("Asia/Tokyo");
        ZonedDateTime tokyoZonedDateTime = currentInstant.atZone(tokyoZoneId);
        System.out.println("亚洲/东京时区的日期时间信息："+tokyoZonedDateTime);

    }

}
