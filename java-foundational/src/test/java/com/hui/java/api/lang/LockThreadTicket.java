package com.hui.java.api.lang;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock锁实现窗口买票
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/11 15:45
 * @since JDK8
 */

public class LockThreadTicket {

    public static void main(String[] args) {

        TicketWindow window = new TicketWindow();

        new Thread(window,"窗口1：").start();
        new Thread(window,"窗口2：").start();
        new Thread(window,"窗口3：").start();
        new Thread(window,"窗口4：").start();


    }

}



class TicketWindow implements Runnable{

    private int ticket = 100;
    private static final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (ticket>0) {
            /*try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            try{
                lock.lock();
                //sellTicket();
                System.out.println(Thread.currentThread().getName()+"正在卖最后第："+ticket+"张票");
                ticket--;
            }finally{
                lock.unlock();
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*public void sellTicket(){

        System.out.println(Thread.currentThread().getName()+"正在卖最后第："+ticket+"张票");
        ticket--;
    }*/
}