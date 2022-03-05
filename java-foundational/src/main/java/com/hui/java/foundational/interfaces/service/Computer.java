package com.hui.java.foundational.interfaces.service;

/**
 * 电脑
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/11 15:18
 * @since JDK8
 */

public class Computer {

    public void showComputerUSBDeviceInfo(USB usb1,USB usb2){
        System.out.println("电脑的第一个USB接口连接的设备是："+usb1.getDeviceInfo());
        System.out.println("电脑的第二个USB接口连接的设备是："+usb2.getDeviceInfo());
    }

}
