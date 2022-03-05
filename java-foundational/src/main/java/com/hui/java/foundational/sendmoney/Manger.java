package com.hui.java.foundational.sendmoney;

import java.util.ArrayList;

/**
 * 群主
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/2 17:42
 * @since JDK8
 */

public class Manger extends User {

    public Manger() {
    }

    public Manger(String name, int money) {
        super(name, money);
    }

    public ArrayList<Integer> send(int redmoney,int count){

        ArrayList<Integer> redlist = new ArrayList<>();

        int totalmoney = this.getMoney();

        if (redmoney>totalmoney){
            System.out.println("你没有这么多钱！");
            return null;
        }

        this.setMoney(totalmoney-redmoney);

        for (int i = 0; i < count-1; i++) {
            redlist.add(redmoney/count);
        }

        redlist.add((redmoney/count)+(redmoney%count));

        return redlist;
    }
}
