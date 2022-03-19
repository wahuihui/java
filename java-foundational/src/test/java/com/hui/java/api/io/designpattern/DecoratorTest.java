package com.hui.java.api.io.designpattern;

import com.hui.java.foundational.interfaces.service.Cellphone;
import com.hui.java.foundational.interfaces.service.Computer;

/**
 * 装饰者模式的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/19 15:37
 * @since JDK8
 */

public class DecoratorTest {

    public static void main(String[] args) {

        Computer computer = new Computer();

        Cellphone cellphone = new Cellphone();
        cellphone.setBrand("华为");
        cellphone.setModel("华为P50 Pro");
        cellphone.setPrice(6499);
        cellphone.setWeight(228);
        cellphone.setColor("白色");

        BaseDao<Cellphone> baseDao = new DefaultBaseDaoImpl<>();
        //没有增强 直接从数据库获取
        System.out.println("*****没有增强 直接从数据库获取*****");
        Cellphone formDBCellphone = baseDao.get(cellphone);
        System.out.println(formDBCellphone);

        BaseDao<Cellphone> cacheDao = new CacheDaoImpl<>(baseDao);
        //增强的 先查缓存有就直接返回，否则查数据库
        System.out.println("*****增强的 先查缓存有就直接返回，否则查数据库*****");
        Cellphone formCacheCellphone = cacheDao.get(cellphone);
        System.out.println(formCacheCellphone);

    }

}
