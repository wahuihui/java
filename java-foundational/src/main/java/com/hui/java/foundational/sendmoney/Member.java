package com.hui.java.foundational.sendmoney;

import java.util.ArrayList;
import java.util.Random;

/**
 * 群成员
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/2 17:53
 * @since JDK8
 */

public class Member extends User {

    public Member() {
    }

    public Member(String name, int money) {
        super(name, money);
    }

    public void receive(ArrayList<Integer> list){

        int index = new Random().nextInt(list.size());

        int money = list.remove(index);

        this.setMoney(this.getMoney()+money);
    }
}
