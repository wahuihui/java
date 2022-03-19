package com.hui.java.api.io.designpattern;

/**
 * 被装饰类
 * 统一数据访问接口的默认实现，所有的操作直接操作数据
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/19 15:14
 * @since JDK8
 */

public class DefaultBaseDaoImpl<T> implements BaseDao<T> {
    @Override
    public int add(T element) {
        if (null!=element){
            System.out.println("数据库新增数据成功");
            return 1;
        }
        return 0;
    }

    @Override
    public int delete(T element) {
        if (null!=element){
            System.out.println("数据库删除数据成功");
            return 1;
        }
        return 0;
    }

    @Override
    public T get(T element) {
        System.out.println("数据库查询数据成功");
        return element;
    }
}
