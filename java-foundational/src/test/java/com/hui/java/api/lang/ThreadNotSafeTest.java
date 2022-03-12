package com.hui.java.api.lang;

/**
 * 多线程模拟窗口售票
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/10 20:36
 * @since JDK8
 */

public class ThreadNotSafeTest {

    public static void main(String[] args) {

        TicketWindows ticketWindows = new TicketWindows();

        new Thread(ticketWindows,"窗口1：").start();
        new Thread(ticketWindows,"窗口2：").start();
        new Thread(ticketWindows,"窗口3：").start();
        new Thread(ticketWindows,"窗口4：").start();

    }


}


class TicketWindows implements Runnable{

    private int ticketNums = 100;
    boolean flag = true;

    @Override
    public void run() {

        while (flag) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sellTicket();
        }
    }

    public synchronized void sellTicket(){
        if (ticketNums<=0){
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName()+"正在售最后第"+ticketNums+"张票");
        ticketNums--;
    }
}