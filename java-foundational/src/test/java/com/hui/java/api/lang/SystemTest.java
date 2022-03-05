package com.hui.java.api.lang;

import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

/**
 * System类的常用方法测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/14 15:32
 * @since JDK8
 */

public class SystemTest {

    /**
     * 获取所有环境变量信息
     */
    @Test
    public void testSystemGetEnv(){
        Map<String,String> env = System.getenv();

        for (String name:env.keySet()){
            System.out.println(name+"----->"+env.get(name));
        }

    }


    /**
     * 获取系统指定的环境变量信息
     */
    @Test
    public void testSystemGetEnvByName(){
        System.out.println(System.getenv("JAVA_HOME"));
        System.out.println(System.getenv("MAVEN_HOME"));
    }


    /**
     * 获取系统属性
     */
    @Test
    public void testSystemProperties(){
        Properties properties = System.getProperties();
        try {
            properties.store(new FileOutputStream("system_properties.txt"),"Windows System Properties");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 获取指定的系统属性
     */
    @Test
    public void testSystemGetProperties(){
        //获取当前操作系统名称
        System.out.println(System.getProperty("os.name"));
        //获取当前操作系统换行分隔符
        System.out.println(System.getProperty("line.separator"));
        //获取当前操作系统的文件编码
        System.out.println(System.getProperty("file.encoding"));
        //获取当前Java版本
        System.out.println(System.getProperty("java.version"));
        //获取当前Java的字节码版本
        System.out.println(System.getProperty("java.class.version"));
        //获取当前Java虚拟机的版本
        System.out.println(System.getProperty("java.vm.name"));
    }

    /**
     * 退出Java虚拟机
     */
    @Test
    public void testSystemExit(){
        // 0 正常退出
        //非0 异常退出
        System.exit(0);
        System.out.println("hahaha");
    }

    /**
     * 数组复制
     */
    @Test
    public void testSystemArrayCopy(){
        int[] src = {1,2,3,4,5,6,7,8,9};
        int[] dest = {10,20,30,40,50,60,70,80,90};
        System.arraycopy(src,0,dest,dest.length-5,5);
        System.out.println("原数组的内容："+ Arrays.toString(src));
        System.out.println("新数组的内容："+ Arrays.toString(dest));
    }

}
