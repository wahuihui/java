package com.hui.java.foundational.sendmoney;

import java.util.ArrayList;

/**
 * 发红包的测试类
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/2 18:01
 * @since JDK8
 */

public class Test {

    public static void main(String[] args) {

        Manger manger = new Manger("群主",100);

        Member one = new Member("成员A",0);
        Member two = new Member("成员B",0);
        Member three = new Member("成员C",0);

        manger.show();

        one.show();
        two.show();
        three.show();
        System.out.println("====================");

        ArrayList<Integer> send = manger.send(40, 3);
        one.receive(send);
        two.receive(send);
        three.receive(send);

        manger.show();

        one.show();
        two.show();
        three.show();

    }

}
