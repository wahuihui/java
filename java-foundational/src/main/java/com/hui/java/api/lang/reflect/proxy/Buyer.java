package com.hui.java.api.lang.reflect.proxy;

/**
 * 代理模式的代理角色（买手）
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/26 15:03
 * @since JDK8
 */

public class Buyer implements Shopping {
    final User user;

    public Buyer(User user){
        this.user = user;
    }

    @Override
    public void buyCellphone() {
        System.out.println("买手：买手登陆商城成功");
        System.out.println("买手：买手抢到了手机");
        user.buyCellphone();
    }
}
