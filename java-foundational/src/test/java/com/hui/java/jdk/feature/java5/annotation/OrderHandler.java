package com.hui.java.jdk.feature.java5.annotation;

/**
 * @author hui 1154437939@qq.com
 * @version 2022/3/24 20:27
 * @since JDK8
 */

public class OrderHandler {

    @Test
    public void register(){
        System.out.println("用户注册京东成功");
    }

    @Test
    public void login(){
        System.out.println("用户登录京东成功");
    }

    @Test
    public void browse(){
        System.out.println("用户正在浏览商品");
    }

    @Test
    public void addShoppingCart(){
        System.out.println("用户台添加商品到购物车");
    }

    @Test
    public void pay(){
        System.out.println("用户支付成功");
    }

    @Test
    public void commitOrder(){
        System.out.println("用户提交了订单");
    }
}
