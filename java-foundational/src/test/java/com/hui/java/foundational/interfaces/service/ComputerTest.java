package com.hui.java.foundational.interfaces.service;

/**
 * 接口的案例：接口作为方法的形参
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/11 15:26
 * @since JDK8
 */

public class ComputerTest {

    public static void main(String[] args) {
        Computer computer = new Computer();

        USB usb1 = new Mouse();
        USB usb2 = new HardDisk();

        computer.showComputerUSBDeviceInfo(usb1,usb2);
    }

}
