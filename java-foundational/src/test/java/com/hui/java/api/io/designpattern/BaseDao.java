package com.hui.java.api.io.designpattern;

/**
 * 统一数据访问接口
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/19 15:10
 * @since JDK8
 */

public interface BaseDao<T> {

    /**
     * 添加元素
     * @param element
     * @return 受影响的行数
     */
    int add(T element);

    /**
     * 删除元素
     * @param element
     * @return 受影响的行数
     */
    int delete(T element);

    /**
     * 获取元素
     * @param element
     * @return
     */
    T get(T element);
}



























