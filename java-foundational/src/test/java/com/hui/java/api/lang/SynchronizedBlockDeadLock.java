package com.hui.java.api.lang;

import com.sun.scenario.effect.LockableResource;

/**
 * 死锁的案例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/11 16:39
 * @since JDK8
 */

public class SynchronizedBlockDeadLock {

    private static final Object LockA = new Object();
    private static final Object LockB = new Object();


    public static void main(String[] args) {

        new Thread(()->{
            String name = Thread.currentThread().getName();
            synchronized (LockA){
                System.out.println(name+"获取到了A锁");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LockB){
                    System.out.println(name+"同时获取到了A锁和B锁");
                }
            }
        },"线程A: ").start();


        new Thread(()->{
            String name = Thread.currentThread().getName();
            synchronized (LockB){
                System.out.println(name+"获取到了B锁");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LockA){
                    System.out.println(name+"同时获取到了A锁和B锁");
                }
            }
        },"线程B: ").start();

    }


}
