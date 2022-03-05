package com.hui.java.foundational.interfaces.service;

/**
 * 手机类型排序
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/11 17:15
 * @since JDK8
 */

public class CellphoneSort {

    public void sort(Cellphone[] cellphones,Comparator comparator){

        for (int i = 0; i < cellphones.length-1; i++) {
            for (int j = 0; j < cellphones.length-1-i; j++) {
                if (comparator.compare(cellphones[j],cellphones[j+1])>0){
                    Cellphone temp = cellphones[j+1];
                    cellphones[j+1] = cellphones[j];
                    cellphones[j] = temp;
                }
            }
        }

    }
}
