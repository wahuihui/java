package com.hui.java.jdk.feature.java8;

import com.hui.java.foundational.interfaces.service.Cellphone;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 方法引用的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/12 21:35
 * @since JDK8
 */

public class MethodReferenceTest {

    static String getCurrentTime(){
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH时mm分ss秒");
        return simpleDateFormat.format(now);
    }
    /**
     * 打印当前时间
     */
    static void printCurrentTime(){
        System.out.println(getCurrentTime());
    }

    public static void main(String[] args) {
        new Thread(()-> System.out.println(getCurrentTime())).start();

        new Thread(()->printCurrentTime()).start();

        //以上两种情况  使用类成员方法替换Lambda表达式
        new Thread(MethodReferenceTest::printCurrentTime).start();
    }

    /**
     * 构造方法引用的使用
     */
    @Test
    public void testConstructorMethodReference(){
        List<String> modelNameList = new ArrayList<>();

        modelNameList.add("小米12");
        modelNameList.add("苹果13");
        modelNameList.add("魅族18");

        //将List集合元素的内容转换为Cellphone对象
        System.out.println("使用Stream API结合lambda表达式实现");
        List<Cellphone> cellphoneList = modelNameList.stream()
                .map(modelName -> new Cellphone(modelName))
                .collect(Collectors.toList());
        for (Cellphone cellphone : cellphoneList) {
            System.out.println(cellphone);
        }

        //使用Stream API结合构造方法引用实现
        System.out.println("使用Stream API结合构造方法引用实现");
        List<Cellphone> cellphones = modelNameList.stream().map(Cellphone::new)
                .collect(Collectors.toList());
        for (Cellphone cellphone : cellphones) {
            System.out.println(cellphone);
        }
    }

    /**
     * 静态方法引用的使用
     */
    @Test
    public void testStaticMethodReference(){
        List<String> orderStrIdList = new ArrayList<>();

        orderStrIdList.add("1000");
        orderStrIdList.add("1001");
        orderStrIdList.add("1002");

        //将订单号转化为整数
        List<Integer> orderIdList = new ArrayList<>();

        orderStrIdList.stream().map((orderStrId)->Integer.parseInt(orderStrId))
                .forEach((orderId)->orderIdList.add(orderId));
        System.out.println("使用Stream API结合Lambda表达式实现");

        for (Integer orderId : orderIdList) {
            System.out.println(orderId);
        }

        List<Integer> orderIds = new ArrayList<>();
        orderStrIdList.stream().map(Integer::valueOf)
                .forEach(orderIds::add);

        System.out.println("使用Stream API结合静态方法引用实现");
        for (Integer orderId : orderIds) {
            System.out.println(orderId);
        }
    }

    /**
     * 对象成员方法引用的使用
     */
    @Test
    public void testObjectMemberMethodReference(){
        List<String> modelNameList = new ArrayList<>();

        modelNameList.add("小米12");
        modelNameList.add("苹果13");
        modelNameList.add("魅族18");

        //使用Stream API结合Lambda表达式将集合的元素遍历输出
        System.out.println("使用Stream API结合Lambda表达式实现");
        modelNameList.stream().forEach((modelName)-> System.out.println(modelName));

        System.out.println("使用Stream API结合对象成员方法引用实现");
        modelNameList.stream().forEach(System.out::println);
    }

    /**
     * 类成员方法引用的使用
     */
    @Test
    public void testClassMemberMethodReference(){

        List<String> modelNameList = new ArrayList<>();

        modelNameList.add("小米12");
        modelNameList.add("苹果13");
        modelNameList.add("魅族18");

        //使用Stream API结合Lambda表达式将集合中的字符串转换为对应的长度遍历输出
        System.out.println("使用Stream API结合Lambda表达式实现");
        modelNameList.stream().map((modelName)->{
            return modelName.length();
        }).forEach(System.out::println);

        System.out.println("使用Stream API结合类成员方法引用实现");
        modelNameList.stream().map(String::length).forEach(System.out::println);
    }

}
















