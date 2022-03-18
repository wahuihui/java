package com.hui.java.api.io;

import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 缓冲字符流的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/18 17:23
 * @since JDK8
 */

public class BufferedReaderBufferedWriterTest {

    /**
     * 使用BufferedReader和BufferedWriter实现文本文件的复制
     */
    @Test
    public void testTxtFileCopy(){
        long startTime = System.currentTimeMillis();
        File sourceFile = new File("E:\\io\\雪中悍刀行.txt");
        File targetFile = new File("E:\\io\\buffered.txt");
        try (
                Reader reader = new FileReader(sourceFile);
                Writer writer = new FileWriter(targetFile);

                BufferedReader bufferedReader = new BufferedReader(reader);
                BufferedWriter bufferedWriter = new BufferedWriter(writer)
        ){
            char[] buffer = new char[1024];
            int bufLen;
            while ((bufLen=bufferedReader.read(buffer))!=-1){
                bufferedWriter.write(buffer,0,bufLen);
            }
            long endTime = System.currentTimeMillis();
            long Time = endTime-startTime;
            System.out.println("使用BufferedReader和BufferedWriter实现文本文件的复制，耗时："+Time+" 毫秒");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 换行写数据
     */
    @Test
    public void testBufferedWriterNewLine(){
        File targetFile = new File("E:\\io\\writer.txt");

        try (
                Writer writer = new FileWriter(targetFile);
                BufferedWriter bufferedWriter = new BufferedWriter(writer)
        ){
            bufferedWriter.write("辉辉学Java");
            //换行
            bufferedWriter.newLine();
            bufferedWriter.write("辉辉学前端");
            bufferedWriter.newLine();
            bufferedWriter.write("辉辉学MySQL");
            bufferedWriter.newLine();
            bufferedWriter.write("辉辉学Spring");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 读取每一行数据
     */
    @Test
    public void testBufferedReaderReadLine(){
        File targetFile = new File("E:\\io\\writer.txt");
        try (
                Reader reader = new FileReader(targetFile);
                BufferedReader bufferedReader = new BufferedReader(reader)
        ){
            String content;
            while ((content=bufferedReader.readLine())!=null){
                System.out.println(content);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 对文件内容升序排序
     */
    @Test
    public void testFileContentSort(){
        File targetFile = new File("E:\\io\\writer.txt");
        try (
                Reader reader = new FileReader(targetFile);
                BufferedReader bufferedReader = new BufferedReader(reader)
        ){
            String content;
            List<String> list = new ArrayList<>();
            while ((content=bufferedReader.readLine())!=null){
                System.out.println(content);
                list.add(content);
            }

            Collections.sort(list);

            Writer writer = new FileWriter(targetFile);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            for (String sortContent : list) {
                bufferedWriter.write(sortContent);
                bufferedWriter.newLine();
                System.out.println(sortContent);
            }

            bufferedWriter.close();
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
