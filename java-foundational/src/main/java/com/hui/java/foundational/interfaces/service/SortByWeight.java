package com.hui.java.foundational.interfaces.service;

/**
 * 重量排序
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/11 17:09
 * @since JDK8
 */

public class SortByWeight implements Comparator{
    @Override
    public int compare(Cellphone source, Cellphone target) {
        return source.getWeight()- target.getWeight();
    }
}
