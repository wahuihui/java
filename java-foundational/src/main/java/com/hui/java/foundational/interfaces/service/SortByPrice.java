package com.hui.java.foundational.interfaces.service;

/**
 * 价格比较
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/11 16:54
 * @since JDK8
 */

public class SortByPrice implements Comparator {
    @Override
    public int compare(Cellphone source, Cellphone target) {
        return source.getPrice()- target.getPrice();
    }
}
