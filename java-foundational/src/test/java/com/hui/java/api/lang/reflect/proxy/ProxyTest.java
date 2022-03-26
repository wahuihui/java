package com.hui.java.api.lang.reflect.proxy;

import org.testng.annotations.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 代理模式的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/26 15:13
 * @since JDK8
 */

public class ProxyTest {

    /**
     * 静态代理模式的使用
     */
    @Test
    public void staticProxy(){
        //被代理的对象
        User user = new User();

        //代理对象
        Buyer buyer = new Buyer(user);

        buyer.buyCellphone();
    }

    /**
     * 动态代理代理无参数无返回值的方法
     */
    @Test
    public void dynamicProxyWithoutArgsWithoutValue(){
        User user = new User();

        Shopping shopping = (Shopping) Proxy.newProxyInstance(
                User.class.getClassLoader(), User.class.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("buyCellphone")){
                            System.out.println("买手：买手登录了商城");
                            System.out.println("买手：买手抢到了手机");
                            method.invoke(user);
                        }
                        return null;
                    }
                }
        );
        shopping.buyCellphone();
    }


    /**
     * 动态代理代理有参数有返回值的方法
     */
    @Test
    public void dynamicProxyWithArgsWithReturnValue(){
        //被代理对象
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(100);
        arrayList.add(100);
        arrayList.add(200);
        arrayList.add(300);

        List<Integer> proxyList = (List<Integer>) Proxy.newProxyInstance(
                ArrayList.class.getClassLoader(), ArrayList.class.getInterfaces(),
                (Object proxy, Method method, Object[] args)->{
                    Object returnValue = method.invoke(arrayList, args);

                    if (method.getName().equals("remove")){
                        Iterator<Integer> iterator = arrayList.iterator();
                        while (iterator.hasNext()) {
                            Integer value = iterator.next();
                            if (value.equals(args[0])){
                                iterator.remove();
                            }
                        }
                    }
                    return returnValue;
                }
        );
        proxyList.remove(Integer.valueOf(100));
        System.out.println("删除元素的值为100之后，集合的元素内容为："+arrayList);
    }
}

















