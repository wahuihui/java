package com.hui.java.api.lang.reflect;


import com.hui.java.jdk.feature.java5.annotation.Test;

import java.lang.reflect.Method;

/**
 * 反射工具类
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/24 20:22
 * @since JDK8
 */

public final class ReflectUtils {


    public static <T> void mockTest(Class<T> clazz){

        try {
            T type = clazz.newInstance();
            //获取类的所有的公共的
            Method[] methods = clazz.getMethods();
            if (null!=methods&&methods.length>0){
                for (Method method : methods) {
                    Class<?> returnType = method.getReturnType();
                    if (returnType.getName().equals("void")&&method.getParameterCount()==0){
                        Test testAnnotation = method.getAnnotation(Test.class);
                        if (null!=testAnnotation){
                            method.invoke(type);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
