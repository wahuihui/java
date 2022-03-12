package com.hui.java.api.util.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/12 15:58
 * @since JDK8
 */

public class ExecutorsTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(50);

        for (int i = 0; i < 5; i++) {
            executorService.submit(new PrintTask());
        }

        executorService.shutdown();


    }

}


class PrintTask implements Runnable{

    @Override
    public void run() {
        String name = Thread.currentThread().getName()+"： ";
        System.out.println(name+ new SimpleDateFormat("HH时mm分ss秒").format(new Date()));

        //当前线程等待3秒
        try {
            System.out.println(name+"准备等3秒");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+ new SimpleDateFormat("HH时mm分ss秒").format(new Date()));
    }
}
