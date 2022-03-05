package com.hui.java.foundational.interfaces.service;

import javafx.scene.control.Cell;

import java.util.Arrays;

/**
 * 接口的案例：接口作为方法的形参->对象数组排序
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/11 16:27
 * @since JDK8
 */

public class SortTest {

    public static void main(String[] args) {

        Cellphone[] cellphones = {
                new Cellphone("苹果12","apple",6799,"黑色",168),
                new Cellphone("三星S21","三星",7699,"黑色",198),
                new Cellphone("小米12Pro","小米",5699,"黑色",178),
                new Cellphone("华为P50Pro","华为",6399,"黑色",178),
        };

        System.out.println("排序之前：");

        for (Cellphone cellphone : cellphones){
            System.out.println(cellphone);
        }

        CellphoneSort cellphoneSort = new CellphoneSort();
        cellphoneSort.sort(cellphones,new SortByWeight());

        System.out.println("排序之后：");

        for (Cellphone cellphone : cellphones){
            System.out.println(cellphone);
        }
    }
}
