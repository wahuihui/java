package com.hui.java.api.io;

import org.testng.annotations.Test;

import java.io.*;

/**
 * FileWriter的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/17 17:52
 * @since JDK8
 */

public class FileWriterTest {

    /**
     * 创建FileWriter对象，文件不存在会自动创建
     * 创建FileWriter对象，append默认为false，文件存在会清空文件内容
     * 创建FileWriter对象，如果目录不存在，那么就会引发 java.io.FileNotFoundException
     *
     * @throws java.io.IOException
     */
    @Test
    public void testFileWriterConstructorAppendFalse() throws IOException {
        File file = new File("E:\\io\\writer\\writer.txt");
        Writer writer = new FileWriter(file);

        String path = "E:\\io\\writer\\writer.txt";
        writer = new FileWriter(path);

        writer.close();
    }

    /**
     * 创建FileWriter对象，文件不存在会自动创建
     * 创建FileWriter对象，append为True，文件存在会清空文件内容
     * 创建FileWriter对象，如果目录不存在，那么就会引发 java.io.FileNotFoundException
     *
     */
    @Test
    public void testFileWriterConstructorAppendTrue() throws IOException {
        File file = new File("E:\\io\\writer\\writer.txt");
        Writer writer = new FileWriter(file,true);
        writer.close();
    }

    /**
     * 使用FileWriter往文件中写数据
     * @throws IOException
     */
    @Test
    public void testFileWriterWriteData() throws IOException {
        File file = new File("E:\\io\\writer\\writer.txt");
        Writer writer = new FileWriter(file,false);
        //65对应的字符是A
        writer.write(65);

        writer.flush();

        writer.write(66);

        writer.write("辉辉学Java");

        char[] chs = new char[]{'C','+','+','!'};
        writer.write(chs);

        char[] offsetChs = {'P','y','t','h','o','n','.','w'};
        writer.write(offsetChs,0,7);

        //关闭流之后不能再使用
        writer.close();
    }

    /**
     * 基于FileReader和FileWriter实现文本文件的复制
     */
    @Test
    public void testTestFileCopy() throws IOException {
        //准备复制的源文件
        File file = new File("E:\\io\\沁园春 雪.txt");
        //字符输入流
        Reader reader = new FileReader(file);

        //准备复制的目标文件，就是将源文件的内容复制到哪里
        File target = new File("E:\\io\\沁园春 雪_copy.txt");
        //字符输出流
        Writer writer = new FileWriter(target);

        //每次读取的字符内容
        char[] buffer = new char[10];
        //每次读取字符内容的长度(字符的个数)
        int bufLen = 0;
        //当未达到文件末尾时，循环读取  的文本内容，将读取到的内容存储到 copy.txt，并且将读取到的字符个数赋值给copy.txt
        while ((bufLen= reader.read(buffer))!=-1){
            //将每次读取到内容写到 copy.txt
            writer.write(buffer,0,bufLen);
        }
        //关闭字符输出流
        writer.close();
        //关闭字符输入流
        reader.close();
    }
}























