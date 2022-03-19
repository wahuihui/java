package com.hui.java.api.io.designpattern;

/**
 * 装饰类：缓存的实现
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/19 15:18
 * @since JDK8
 */

public class CacheDaoImpl<T> implements BaseDao<T> {
    private BaseDao<T> baseDao;

    public CacheDaoImpl(BaseDao<T> baseDao){
        this.baseDao = baseDao;
    }


    @Override
    public int add(T element) {
        return baseDao.add(element);
    }

    @Override
    public int delete(T element) {
        return baseDao.delete(element);
    }

    @Override
    public T get(T element) {
        if (null!=element){
            T fromCache = getFromCache(element);
            if (null!=fromCache){
                System.out.println("从缓存中获取数据成功");
                return fromCache;
            }else{
                System.out.println("从数据库获取数据成功");
                return baseDao.get(element);
            }
        }
        return null;
    }

    /**
     * 从缓存中获取数据
     * @param element
     * @param <T>
     * @return
     */
    private <T> T getFromCache(T element){
        if (null!=element){
            return element;
        }
        return null;
    }
}
