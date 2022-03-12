package com.hui.java.jdk.feature.java8;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.ref.SoftReference;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream API 的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/12 18:15
 * @since JDK8
 */

public class StreamAPITest {

    List<String> list;

    @BeforeClass
    public void initList(){
        list = new ArrayList<>();

        list.add("孙悟空");
        list.add("猪八戒");
        list.add("沙和尚");
        list.add("唐僧");
        list.add("孙行者");
        list.add("孙大圣");

        System.out.println("初始化list集合的元素："+list);
    }

    /**
     * 使用传统方式操作集合
     * 1.遍历
     * 2.创建新集合存储结果
     */
    @Test
    public void testListOperator(){

        //需求 获取名字长度为3的元素  获取姓孙的元素

        System.out.println("1.用传统方式获取名字长度为3的元素");
        List<String> threeLength = new ArrayList<>();
        for (String name : list) {
            if (name.length()==3){
                threeLength.add(name);
            }
        }

        for (String name : threeLength) {
            System.out.println(name);
        }

        System.out.println("2.用传统方式获取姓孙的元素");
        List<String> sunList = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("孙")){
                sunList.add(name);
            }
        }

        for (String name : sunList) {
            System.out.println(name);
        }
    }

    /**
     * Stream API 不需要遍历集合，也不需要创建新集合存储结果
     */
    @Test
    public void testStreamAPI(){
        System.out.println("1.用Stream API的方式获取名字长度为3的元素");
        list.stream().filter(name->name.length()==3)
                .forEach(name-> System.out.println(name));
        System.out.println("2.用Stream API的方式获取姓孙的元素");
        list.stream().filter(name->name.startsWith("孙"))
                .forEach(name-> System.out.println(name));
    }

    /**
     * Collection获取Stream
     */
    @Test
    public void testCollectionGetStream(){

        List<String> list = new ArrayList<>();
        list.add("北京");
        list.add("上海");
        list.add("广州");

        //List获取Stream
        Stream<String> listStream = list.stream();

        Set<String> set = new HashSet<>();
        //Set获取Stream
        Stream<String> setStream = set.stream();
    }

    /**
     * Map集合获取Stream的三种方式
     */
    @Test
    public void testMapGetStream(){

        Map<String,String> map = new HashMap<>();
        map.put("中国","北京");
        map.put("英国","伦敦");
        map.put("法国","巴黎");

        //map通过keySet()获取Stream
        Stream<String> keySetStream = map.keySet().stream();
        //map通过values()获取Stream
        Stream<String> valuesStream = map.values().stream();
        //map通过entrySet()获取Stream
        Stream<Map.Entry<String, String>> entrySetStream = map.entrySet().stream();
    }

    /**
     * 数组获取Stream
     */
    @Test
    public void testArrayGetStream(){
        String[] cities = {"北京","上海","广州","深圳"};

        Stream<String> arrayStream = Stream.of(cities);
    }

    /**
     * Stream的forEach的使用
     */
    @Test
    public void testStreamForEach(){
        list.stream().forEach(System.out::println);
    }

    /**
     * Stream的count方法的使用
     */
    @Test
    public void testStreamCount(){
        long count = list.stream().count();
        System.out.println(count);
    }

    /**
     * Stream的filter方法的使用
     */
    @Test
    public void testStreamFilter(){
        list.stream().filter(name->name.length()==3)
                .forEach(System.out::println);
    }

    /**
     * Stream的limit方法的使用
     * 如果limit的maxSize超过了流中元素的数量，limit不操作
     * 比如说这个流中只有3个元素，maxSize是5个，那么limit不操作
     */
    @Test
    public void testStreamLimit(){
        list.stream().filter(name->name.length()==2)
                .limit(2).forEach(System.out::println);
    }

    /**
     * Stream的skip的使用
     */
    @Test
    public void testStreamSkip(){
        System.out.println("skip前");
        list.stream().forEach(System.out::println);
        System.out.println("skip后");
        list.stream().skip(2).forEach(System.out::println);
    }

    /**
     *使用Stream的map方法将集合元素的字符串类型转化为(Integer)类型
     */
    @Test
    public void testStreamMap(){
        List<String> orderStrIdList = new ArrayList<>();
        orderStrIdList.add("1000");
        orderStrIdList.add("1001");
        orderStrIdList.add("1002");
        orderStrIdList.add("1003");

        List<Integer> orderIdList = new ArrayList<>();
        orderStrIdList.stream().map(orderStrId->{
            return Integer.valueOf(orderStrId);
        }).forEach(orderId->orderIdList.add(orderId));

        System.out.println("使用Stream的map方法将集合元素的字符串类型转化为(Integer)类型");
        for (Integer orderId : orderIdList) {
            System.out.println(orderId);
        }
    }

    /**
     * 使用Stream的map方法将集合元素的字符串类型转化为字符串类型
     */
    @Test
    public void testStreamMapString(){
        List<String> orderStrIdList = new ArrayList<>();
        orderStrIdList.add("1000");
        orderStrIdList.add("1001");
        orderStrIdList.add("1002");
        orderStrIdList.add("1003");

        List<String> tbOrderIdList = new ArrayList<>();
        orderStrIdList.stream()
                .map(orderStrId->"tb订单号："+orderStrId)
                .forEach(orderStrId->tbOrderIdList.add(orderStrId));

        for (String tbOrderId : tbOrderIdList) {
            System.out.println(tbOrderId);
        }
    }

    /**
     * stream的collect方法的使用
     * collect方法用于收集相关操作之后的结果
     */
    @Test
    public void testStreamCollector(){
        List<String> collectList =
        list.stream().filter(name->name.length()==3)
                .filter(name->name.startsWith("孙"))
                .collect(Collectors.toList());
        for (String name : collectList) {
            System.out.println(name);
        }
    }

}












