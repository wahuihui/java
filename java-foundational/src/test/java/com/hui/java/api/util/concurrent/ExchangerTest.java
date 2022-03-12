package com.hui.java.api.util.concurrent;

import java.util.concurrent.Exchanger;

/**
 * Exchanger的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/12 15:17
 * @since JDK8
 */

public class ExchangerTest {

    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();

        ThreadC threadC = new ThreadC(exchanger);
        ThreadD threadD = new ThreadD(exchanger);

        threadC.setName("C线程：");
        threadD.setName("D线程：");

        threadC.start();
        threadD.start();
    }

}

class ThreadC extends Thread{

    final Exchanger exchanger;

    ThreadC(Exchanger exchanger){
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        String name = Thread.currentThread().getName();
        System.out.println(name+"准备把200块钱给D线程");

        try {
            Object returnValue = exchanger.exchange("200块钱");
            System.out.println(name+"D线程给C线程的数据是"+returnValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class ThreadD extends Thread{

    final Exchanger exchanger;

    ThreadD(Exchanger exchanger){
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        String name = Thread.currentThread().getName();
        System.out.println(name+"准备把5斤龙虾给C线程");

        try {
            Object returnValue = exchanger.exchange("5斤龙虾");
            System.out.println(name+"C线程给D线程的数据是"+returnValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}