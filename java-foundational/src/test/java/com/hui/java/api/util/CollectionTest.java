package com.hui.java.api.util;

import com.hui.java.foundational.interfaces.service.Cellphone;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection接口常用方法的测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/4 20:54
 * @since JDK8
 */

public class CollectionTest {

    Collection<String> collection = new ArrayList<>();

    /**
     * 初始化Collection，该方法会在所有测试方法之前执行
     */
    @BeforeClass
    public void initCollection(){
        collection.add("北京");
        System.out.println("往集合中添加一个元素后，当前集合元素："+collection);

        //子集合
        Collection<String> subCollection = new ArrayList<>();
        subCollection.add("上海");
        subCollection.add("广州");
        subCollection.add("深圳");
        collection.addAll(subCollection);
        System.out.println("将subCollection的所有元素全部添加到collection集合后，当前集合元素："+collection);
    }

    /**
     * 集合添加元素
     *
     * @see java.util.Collection#add(Object)
     * @see java.util.Collection#addAll(Collection)
     */
    @Test
    public void testCollectionAddAll(){
        Collection<String> collection = new ArrayList<>();
        collection.add("北京");
        System.out.println("往集合中添加一个元素后，当前集合元素："+collection);

        Collection<String> subCollection = new ArrayList<>();
        subCollection.add("上海");
        subCollection.add("广州");
        subCollection.add("深圳");

        collection.addAll(subCollection);
        System.out.println("将subCollection的所有元素全部添加到collection集合后，当前集合元素："+collection);
    }

    /**
     * 判断是否包含指定的元素（单个元素，集合）
     *
     */
    @Test
    public void testCollectionContainsAll(){

        boolean isContains = collection.contains("北京");
        System.out.println("collection集合中是否包括北京:"+isContains);

        Collection<String> sameCollection = new ArrayList<>();
        sameCollection.add("北京");
        sameCollection.add("上海");
        sameCollection.add("广州");
        sameCollection.add("深圳");
        boolean isSame = collection.containsAll(sameCollection);
        System.out.println("collection集合是否包含全部的sameCollection元素:"+isSame);

        System.out.println(collection.equals(sameCollection));
    }

    /**
     * 删除集合中指定的元素
     */
    @Test
    public void testCollectionRemoveAll(){
        collection.remove("北京");
        System.out.println("删除北京之后 当前collection集合的元素"+collection);

        Collection<String> subCollection = new ArrayList<>();
        subCollection.add("上海");
        subCollection.add("深圳");

        collection.removeAll(subCollection);
        System.out.println("删除上海和深圳后 当前collection集合的元素"+collection);
    }

    @Test
    public void testCollectionClear(){
        collection.clear();
        System.out.println("清空集合中的所有元素："+collection);
    }

    /**
     * 集合属性相关方面
     */
    @Test
    public void testCollectionSizeIsEmpty(){
        System.out.println("没有清空前，当前collection集合的元素个数："+collection.size());
        System.out.println("没有清空前，当前collection集合是否为空："+collection.isEmpty());
        collection.clear();
        System.out.println("清空后，当前collection集合的元素个数："+collection.size());
        System.out.println("清空后，当前collection集合是否为空："+collection.isEmpty());
    }

    /**
     * 集合与数组的相互转换
     */
    @Test
    public void testCollection2Array(){
        //Collection集合转数组
        Object[] cities = collection.toArray();
        for (Object city : cities) {
            System.out.println(city);
        }

        //数组转List
        List<String> anotherCities = Arrays.asList("苏州", "重庆", "杭州");


        System.out.println("数组转List");
        for (String anotherCity : anotherCities) {
            System.out.println(anotherCity);
        }

    }


    @Test
    public void testCollectionUsage(){
        List<Cellphone> cellphoneList = new ArrayList<>();
        cellphoneList.add(new Cellphone("小米12"));
        cellphoneList.add(new Cellphone("苹果12"));
        cellphoneList.add(new Cellphone("三星S22"));

        System.out.println(cellphoneList);
    }





}


















