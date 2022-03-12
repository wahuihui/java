package com.hui.java.api.util.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Semaphore的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/12 15:05
 * @since JDK8
 */

public class SemaphoreTest {

    public static void main(String[] args) {

        ClassRoom classRoom = new ClassRoom();

        ListenRunnable listenRunnable = new ListenRunnable(classRoom);

        for (int i = 0; i < 100; i++) {
            new Thread(listenRunnable,"同学："+i).start();
        }

    }

}

class ListenRunnable implements Runnable{

    final ClassRoom classRoom;

    ListenRunnable(ClassRoom classRoom){
        this.classRoom = classRoom;
    }

    @Override
    public void run() {
        classRoom.listen();
    }
}



class ClassRoom{
    /**
     * 同时只能让3个人上课
     */
    Semaphore semaphore = new Semaphore(3);

    public void listen(){
        //听课之前获得许可
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String name = Thread.currentThread().getName();
        System.out.println(name+"进入了教室");
        System.out.println(name+"正在听课");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name+"听完了课，并离开教室");
        semaphore.release();

    }

}