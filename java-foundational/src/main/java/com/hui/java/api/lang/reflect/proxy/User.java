package com.hui.java.api.lang.reflect.proxy;

/**
 * 代理模式的被代理角色（普通用户）
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/26 15:03
 * @since JDK8
 */

public class User implements Shopping {

    @Override
    public void buyCellphone() {
        System.out.println("普通用户：普通用户支付订单成功");
    }
}
