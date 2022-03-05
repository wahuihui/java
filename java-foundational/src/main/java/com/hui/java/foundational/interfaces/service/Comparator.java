package com.hui.java.foundational.interfaces.service;

import javafx.scene.control.Cell;

/**
 * 比较器
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/11 16:50
 * @since JDK8
 */

public interface Comparator {
    /**
     * 两个对象的比较
     *  如果source 大于 target 返回 1
     *  如果source 小于 target 返回 -1
     *  如果source 等于 target 返回 0
     * @param source
     * @param target
     * @return
     */
    int compare(Cellphone source, Cellphone target);

}
