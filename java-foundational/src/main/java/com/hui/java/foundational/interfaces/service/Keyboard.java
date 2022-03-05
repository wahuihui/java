package com.hui.java.foundational.interfaces.service;

/**
 * 键盘
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/11 15:22
 * @since JDK8
 */

public class Keyboard implements USB {

    @Override
    public String getDeviceInfo() {
        return "罗技键盘";
    }

}
