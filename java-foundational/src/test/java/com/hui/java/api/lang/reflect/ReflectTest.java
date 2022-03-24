package com.hui.java.api.lang.reflect;

import org.testng.annotations.Test;
import com.hui.java.foundational.interfaces.service.Cellphone;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/24 14:45
 * @since JDK8
 */

public class ReflectTest {

    /**
     * Class对象获取的三种方式
     */
    @Test
    public void testGetClass() {

        Class<Cellphone> cellphoneClass1 = Cellphone.class;

        Cellphone cellphone = new Cellphone();
        final Class<? extends Cellphone> cellphoneClass2 = cellphone.getClass();

        try {
            Class.forName("com.hui.java.foundational.interfaces.service.Cellphone");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Class的常用方法
     */
    @Test
    public void testClassNewInstance() {
        final Class<Cellphone> cellphoneClass = Cellphone.class;

        final String name = cellphoneClass.getName();
        System.out.println("Cellphone的全路径名：" + name);

        System.out.println("cellphone的类名是：" + cellphoneClass.getSimpleName());

        final Class<com.hui.java.api.lang.reflect.Cellphone> cellphoneClassLang = com.hui.java.api.lang.reflect.Cellphone.class;

        com.hui.java.api.lang.reflect.Cellphone cellphoneObject = null;

        try {
            cellphoneObject = cellphoneClassLang.newInstance();
            System.out.println(cellphoneObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用反射操作构造方法-获取构造方法
     */
    @Test
    public void testReflectGetConstructor(){
        Class<Cellphone> cellphoneClass = Cellphone.class;

        try {
            Constructor<Cellphone> constructor = cellphoneClass.getDeclaredConstructor();
            System.out.println("获取Cellphone的无参构造方法的结果是："+constructor);

            Constructor<Cellphone> modelConstructor = cellphoneClass.getDeclaredConstructor(String.class);
            System.out.println("获取Cellphone的带型号参数的构造方法的结果是："+modelConstructor);

            Constructor<Cellphone> modelPriceConstructor = cellphoneClass.getDeclaredConstructor(String.class, Integer.class);
            System.out.println("获取Cellphone的带型号价格参数构造方法的结果是："+modelPriceConstructor);

            Class<com.hui.java.api.lang.reflect.Cellphone> cellphoneClassLang = com.hui.java.api.lang.reflect.Cellphone.class;
            Constructor<com.hui.java.api.lang.reflect.Cellphone> privateConstructor = cellphoneClassLang.getDeclaredConstructor();
            System.out.println("获取Cellphone的私有构造方法的结果是："+privateConstructor);

            //获取所有Cellphone的构造方法，包括所有的访问权限
            Constructor<?>[] allConstructor = cellphoneClassLang.getDeclaredConstructors();
            for (Constructor<?> currentConstructor : allConstructor) {
                System.out.println("获取Cellphone的所有的构造方法："+currentConstructor);
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用反射的方式创建对象
     */
    @Test
    public void testReflectConstructorNewInstance(){
        Class<com.hui.java.api.lang.reflect.Cellphone> cellphoneClass = com.hui.java.api.lang.reflect.Cellphone.class;

        try {
            Constructor<com.hui.java.api.lang.reflect.Cellphone> privateConstructor = cellphoneClass.getDeclaredConstructor();
            //绕开权限检查
            privateConstructor.setAccessible(true);

            //使用反射创建Cellphone
            com.hui.java.api.lang.reflect.Cellphone cellphone = privateConstructor.newInstance();
            System.out.println(cellphone);

            Constructor<com.hui.java.api.lang.reflect.Cellphone> stringConstructor = cellphoneClass.getDeclaredConstructor(String.class);
            final com.hui.java.api.lang.reflect.Cellphone stringArgsCellphone = stringConstructor.newInstance("iphone12");
            System.out.println("调用带字符串参数的构造方法之后 Cellphone对象的model属性值是："+stringArgsCellphone.getModel());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用反射获取类的方法
     */
    @Test
    public void testReflectMethodGetMethod(){
        Class<Cellphone> cellphoneClass = Cellphone.class;

        try {
            Method callMethod = cellphoneClass.getDeclaredMethod("call", long.class);
            System.out.println("Cellphone对象的call方法的信息是："+callMethod);

            Method[] allMethod = cellphoneClass.getDeclaredMethods();
            System.out.println("Cellphone的所有方法是：");
            for (Method currentMethod : allMethod) {
                System.out.println(currentMethod);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射调用方法
     */
    @Test
    public void testReflectMethodInvoke(){
        Class<Cellphone> cellphoneClass = Cellphone.class;

        try {
            Cellphone cellphone = cellphoneClass.newInstance();
            Method callMethod = cellphoneClass.getDeclaredMethod("call", long.class);
            callMethod.invoke(cellphone,15896670419L);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射获取类成员变量
     */
    @Test
    public void testReflectFieldGet(){
        Class<Cellphone> cellphoneClass = Cellphone.class;

        try {
            Field modelField = cellphoneClass.getDeclaredField("model");
            System.out.println("modelField表示的成员变量是："+modelField);

            Field weightField = cellphoneClass.getDeclaredField("weight");
            System.out.println("weightField表示的成员变量是："+weightField);

            System.out.println("cellPhone的所有成员变量");
            Field[] allField = cellphoneClass.getDeclaredFields();
            for (Field field : allField) {
                System.out.println(field);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用反射获取成员变量的值
     * 使用反射设置成员变量的值
     */
    @Test
    public void testReflectFieldGetSet(){

        Class<Cellphone> cellphoneClass = Cellphone.class;

        try {
            Cellphone cellphone = cellphoneClass.newInstance();
            Field modelField = cellphoneClass.getDeclaredField("model");

            modelField.setAccessible(true);
            modelField.set(cellphone,"iphone12");
            System.out.println("使用反射获取cellphone的型号是："+cellphone.getModel());

            Field weightField = cellphoneClass.getDeclaredField("weight");
            weightField.setAccessible(true);
            weightField.set(cellphone,200);
            System.out.println("使用反射获取cellphone的重量是："+cellphone.getWeight());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

















