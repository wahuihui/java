package com.hui.java.foundational.object;

import org.testng.annotations.Test;

/**
 * 矩形
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/19 12:38
 * @since JDK8
 */

public class Rectangle {


    @Test
    public void myTest() {
        long startTime = System.currentTimeMillis();
        int length = 1000;
        int width = 1000;
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= width; j++) {
                if (i > 1 && i < length && j > 1 && j < width) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }

    @Test
    public void youTest() {
        long startTime = System.currentTimeMillis();
        int length = 1000;
        int width = 1000;
        for (int i = 1; i < length; i++) {
            if (i == 1 || i == length-1) {
                for (int j = 1; j < width; j++) {
                    System.out.print("* ");
                }
            } else {
                for (int j = 1; j < width; j++) {
                    if (j == 1 || j == width-2) {
                        System.out.print("* ");
                    }
                    System.out.print("  ");
                }

            }
            System.out.println();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
