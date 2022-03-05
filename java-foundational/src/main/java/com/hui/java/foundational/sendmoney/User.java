package com.hui.java.foundational.sendmoney;

/**
 * 成员
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/2 17:36
 * @since JDK8
 */

public class User {

    private String name;
    private int money;

    public User() {
    }

    public User(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void show(){
        System.out.println("我叫："+this.name+"，我有："+this.money);
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getMoney() {
        return money;
    }

    public User setMoney(int money) {
        this.money = money;
        return this;
    }
}
