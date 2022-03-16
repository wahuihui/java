package com.hui.java.api.io;

import org.testng.annotations.Test;

import java.io.*;

/**
 * FileOutputStream类的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/16 21:48
 * @since JDK8
 */

public class FileOutputStreamTest {

    /**
     * 创建FileOutputStream对象，文件不存在会自动创建
     * 创建FileOutputStream对象，文件存在会清空文件内容
     * 创建FileOutputStream对象，如果目录不存在，那么就会引发 文件不存在异常
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testFileOutStreamConstructor() throws FileNotFoundException {
        File file = new File("E:\\io\\outputstream\\test.txt");
        OutputStream outputStream = new FileOutputStream(file);
        String path = "E:\\io\\outputstream\\test.txt";
        outputStream = new FileOutputStream(path);
    }

    /**
     * 使用FileOutputSteam以字节为单位往指定的文件写数据
     * FileOutputStream#write(int a)不能写中文
     */
    @Test
    public void testFileOutputStreamWriteData() throws IOException {
        File file = new File("E:\\io\\outputstream\\test.txt");
        OutputStream outputStream = new FileOutputStream(file);

        outputStream.write(65);

        byte[] data = {66,67,68,69,70};
        outputStream.write(data);

        byte[] offSetData = {48,49,50,51,52,53,54,55};
        outputStream.write(offSetData,0,5);

        int chinese = '中';
        System.out.println("中对应的编码为:"+chinese);

        //outputStream.write(20013);

        outputStream.close();
    }

    /**
     * 使用FileOutputStream实现换行写数据
     * @throws IOException
     */
    @Test
    public void testFileOutputStreamWriteDataNewLine() throws IOException {
        File file = new File("E:\\io\\outputstream\\test.txt");
        OutputStream outputStream = new FileOutputStream(file);

        outputStream.write("辉辉学Java\n".getBytes());
        outputStream.write("辉辉学前端\n".getBytes());
        outputStream.write("辉辉学MySQL\n".getBytes());

        outputStream.close();
    }

    /**
     * 使用FileOutputStream实现文件内容的拼接
     */
    @Test
    public void testFileOutputStreamWriteDataAppend() throws IOException {
        File file = new File("E:\\io\\outputstream\\test.txt");
        OutputStream outputStream = new FileOutputStream(file,true);
        outputStream.write("辉辉学Python\n".getBytes());
        outputStream.write("辉辉学C++\n".getBytes());

        outputStream.close();
    }

}













