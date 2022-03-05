package com.hui.java.foundational.interfaces.service;

/**
 * 鼠标
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/11 15:20
 * @since JDK8
 */

public class Mouse implements USB {


    @Override
    public String getDeviceInfo() {
        return "雷蛇鼠标";
    }
}
