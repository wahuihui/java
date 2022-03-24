package com.hui.java.api.lang.reflect;

import org.testng.annotations.Test;

/**
 * 类加载器的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/24 14:45
 * @since JDK8
 */

public class ClassLoaderTest {

    /**
     * 类加载的时机
     */
    @Test
    public void testClassLoader(){
        //1. 创建类的实例
        //Cellphone cellphone = new Cellphone();

        Cellphone smartphone = new Smartphone("iphone12");
    }


    /**
     * 获取ClassLoader
     */
    @Test
    public void testGetClassLoader(){

        System.out.println("自定义的类加载器："+Cellphone.class.getClassLoader());;

        //null表示根类加载器
        System.out.println("JDK的String的类加载器是："+String.class.getClassLoader());
    }
}


class Cellphone{
    //静态代码块在类加载时侯会被执行，而且只会执行一次
    static {
        System.out.println("执行Cellphone的静态代码块");
    }

    private Cellphone(){}

    private String model;

    static String defaultCountry;

    public String getModel() {
        return model;
    }

    public Cellphone setModel(String model) {
        this.model = model;
        return this;
    }

    public static String getDefaultCountry() {
        return defaultCountry;
    }

    public static void setDefaultCountry(String defaultCountry) {
        Cellphone.defaultCountry = defaultCountry;
    }

    public Cellphone(String model){
        this.model=model;
    }

    static void printDefaultCountry(){
        System.out.println(defaultCountry);
    }
}

class Smartphone extends Cellphone{

    public Smartphone(String model) {
        super(model);
    }
}


























