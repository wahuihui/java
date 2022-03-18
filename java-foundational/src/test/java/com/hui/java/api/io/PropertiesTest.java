package com.hui.java.api.io;

import jdk.internal.util.xml.impl.Input;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/**
 * Properties的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/17 21:52
 * @since JDK8
 */

public class PropertiesTest {

    /**
     * Properties读取文件
     */
    @Test
    public void testPropertiesReadFile(){

        try (
                //try-with-resources自动关闭资源
                //从类路径加载application.properties
                // 本项目的类加载路径是 E:\Study\java\java-foundational\src\main\resources\application.properties
                InputStream inputStream = PropertiesTest.class.getClassLoader().getResourceAsStream("application.properties");
                //InputStream inputStream = new FileInputStream("E:\\Study\\java\\java-foundational\\src\\main\\resources\\application.properties");
        ){

            Properties properties = new Properties();
            properties.load(inputStream);

            Set<String> propertyNames = properties.stringPropertyNames();
            for (String propertyName : propertyNames) {
                Object propertyValue = properties.get(propertyName);
                System.out.println("属性名："+propertyName+" 属性值："+propertyValue);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * 使用Properties写文件
     */
    @Test
    public void testPropertiesWriteData(){

        String path = "E:\\Study\\java\\java-foundational\\src\\main\\resources\\user.properties";
        try (
                OutputStream outputStream = new FileOutputStream(path);
        ){
            Properties properties = new Properties();
            properties.setProperty("username","admin");
            properties.setProperty("password","111111");

            properties.store(outputStream,"后台管理系统的默认用户名密码");
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}




















