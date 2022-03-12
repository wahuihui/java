package com.hui.java.api.lang;

/**
 * @author hui 1154437939@qq.com
 * @version 2022/3/11 17:27
 * @since JDK8
 */

public class ThreadSafeVisibilityTest {

    public static void main(String[] args) {

        ThreadSafeVisibility threadSafeVisibility = new ThreadSafeVisibility();
        threadSafeVisibility.setName("子线程：");
        threadSafeVisibility.start();

        while (true){

            /*try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            if (ThreadSafeVisibility.flag==true){
                System.out.println("主线程循环结束");
                break;
            }
        }
    }
}


class ThreadSafeVisibility extends Thread{

    volatile static boolean flag = false;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        //System.out.println(name+"flag值改前"+flag);
        try {
            System.out.println(name+"即将睡5秒种");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = true;
        System.out.println(name+"将flag值改为了"+flag);
    }
}