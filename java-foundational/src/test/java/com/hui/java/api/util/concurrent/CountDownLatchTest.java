package com.hui.java.api.util.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/12 14:46
 * @since JDK8
 */

public class CountDownLatchTest {

    public static void main(String[] args) {

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        new ThreadA(countDownLatch).start();
        new ThreadB(countDownLatch).start();

    }
}


class ThreadA extends Thread{

    final CountDownLatch countDownLatch;

    ThreadA(final CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("1");
        //当调用countDown()减1之后，计数器的值是0，此时会结束等待
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("3");
    }
}


class ThreadB extends Thread{
    final CountDownLatch countDownLatch;

    ThreadB(final CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("2");
        countDownLatch.countDown();
    }
}
