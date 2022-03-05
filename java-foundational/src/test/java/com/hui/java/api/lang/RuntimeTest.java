package com.hui.java.api.lang;

import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Runtime类的常用方法测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/14 16:28
 * @since JDK8
 */

public class RuntimeTest {


    Runtime runtime = Runtime.getRuntime();
    /**
     * 通过Runtime获取Java程序运行时的硬件信息
     */
    @Test
    public void testRuntimeHardware(){

        //对应Windows任务管理器CPU的逻辑处理器数量
        System.out.println("Java运行时环境 可用于Java虚拟机的处理器数量："+runtime.availableProcessors());

        System.out.println("Java运行时环境 Java虚拟机中的可用内存量 ："+runtime.freeMemory()+"字节");
        System.out.println("Java运行时环境 Java虚拟机将尝试使用的的最大内存量 ："+runtime.maxMemory()+"字节");
        System.out.println("Java运行时环境 Java虚拟机中的内存总量 ："+runtime.totalMemory()+"字节");
    }


    @Test
    public void testRuntimeExec(){
        try {
            runtime.exec("calc.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
