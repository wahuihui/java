package com.hui.java.foundational.interfaces.service;

/**
 * 硬盘
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/11 15:30
 * @since JDK8
 */

public class HardDisk implements USB{
    @Override
    public String getDeviceInfo() {
        return "三星硬盘";
    }
}
