package com.hui.java.foundational.exercise;

/**
 * 菱形
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/9 16:56
 * @since JDK8
 */

public class RhombusTest {

    public static void main(String[] args) {

        int row = 10;

        for (int i = 0; i < row; i++) {
            for (int j = row-1; j > i ; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = 0; i < row-1; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = row-1; j > i ; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }


}
