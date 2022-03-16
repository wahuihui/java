package com.hui.java.api.io;

import org.testng.annotations.Test;

import java.io.File;

/**
 * 递归的应用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/16 18:20
 * @since JDK8
 */

public class RecursionTest {

    /**
     * 不合理的递归会导致栈内存溢出错误
     * 该递归调用没有出口
     */
    public void recursionCallV1(){
        recursionCallV1();
    }

    static int count = 0;

    /**
     * 避免栈内存溢出
     */
    public void recursionCallV2(){
        System.out.println("count = " + count);
        count++;
        //当count大于等于3500以后，结束递归
        //因此递归一定要有结束条件
        if (count<4000){
            recursionCallV2();
        }
    }

    /**
     * 递归的调用
     */
    @Test
    public void testRecursionCall(){
        //recursionCallV1();
        recursionCallV2();
    }

    /**
     * 计算n的累加和
     * @param n
     * @return
     */
    public long sum(int n){
        //递归的结束条件
        if (n==1){
            return 1;
        }
        //n+(n-1)的累加和
        return n+sum(n-1);
    }

    @Test
    public void testSum(){
        System.out.println("5的累加和的计算结果为：" + sum(5));
    }

    /**
     * n的阶乘
     * @param n
     * @return
     */
    public long factorial(int n){
        if (n==1){
            return 1;
        }
        return n * factorial(n-1);
    }

    @Test
    public void testFactorial(){
        System.out.println("8的阶乘的计算结果为： " + factorial(8));
    }

    long totalFileSize = 0;

    /**
     * 统计指定目录(目录是多级别)的文件大小
     * @param path
     * @return
     */
    public long statisticsFileSize(String path){
        File currentDirectory = new File(path);
        //获取指定目录的一级子目录
        File[] files = currentDirectory.listFiles();
        for (File file : files) {
            //如果file是文件
            if (file.isFile()){
                //累加文件的大小作为最终的统计结果
                totalFileSize += file.length();
                //如果file是文件
            }else if(file.isDirectory()){
                //递归调用统计文件的大小
                statisticsFileSize(file.getAbsolutePath());
            }
        }
        return totalFileSize;
    }

    @Test
    public void testStatisticsFileSize(){
        String path = "E:\\io";
        long fileSize = statisticsFileSize(path);
        System.out.println("io文件夹的大小：" + fileSize);
    }

    /**
     * 删除指定路径的非空文件夹
     * @param path
     */
    public void deleteFolder(String path){
        File file = new File(path);
        //如果file对象关联的路径是文件
        if (file.isFile()){
            file.delete();
            System.out.println(file.getName()+"被删除");
            //return;
        }

        File[] files = file.listFiles();
        if (null!=files){
            for (File currentFile : files) {
                if (currentFile.isFile()){
                    currentFile.delete();
                    System.out.println(currentFile.getName()+"被删除");
                }else if (currentFile.isDirectory()){
                    deleteFolder(currentFile.getAbsolutePath());
                    currentFile.delete();
                    System.out.println(currentFile.getName()+"被删除");
                }
            }
        }
        if (file.isDirectory()){
            file.delete();
            System.out.println(file.getName()+"被删除");
        }
    }

    @Test
    public void testDeleteFolder(){
        String path = "E:\\io";
        deleteFolder(path);
    }

}



















