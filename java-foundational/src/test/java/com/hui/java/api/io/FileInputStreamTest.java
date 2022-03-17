package com.hui.java.api.io;

import org.testng.annotations.Test;

import java.io.*;

/**
 * FileInputStream的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/17 14:31
 * @since JDK8
 */

public class FileInputStreamTest {

    /**
     * FileInputStream创建对象 如果指定目录的文件不存在 会引发FileNotFoundException异常
     */
    @Test
    public void testFileInputStreamConstructor() throws IOException {
        File file = new File("E:\\io\\inputstream\\test.txt");
        InputStream inputStream = new FileInputStream(file);
        String path = "E:\\io\\inputstream\\test.txt";
        inputStream = new FileInputStream(path);
        inputStream.close();
    }

    /**
     * 使用FileInputStream实现读取文件内容。 一次读取一个字节
     */
    @Test
    public void testFileInputStreamReadOneByte() throws IOException {
        File file = new File("E:\\io\\inputstream\\test.txt");
        InputStream inputStream = new FileInputStream(file);

        int value = 0;
        //当流没有达到末尾的时候就循环读，将读取到的返回结果赋值给value
        while ((value=inputStream.read())!=-1){
            //把读取到的数字转化为字符
            char content = (char) value;
            //输出到终端
            System.out.print(content);
        }

        inputStream.close();
    }

    /**
     * 使用FileInputStream实现读取文件内容。 一次读取多个字节
     */
    @Test
    public void testFileInputStreamReadManyByte() throws IOException {
        File file = new File("E:\\io\\inputstream\\test.txt");
        InputStream inputStream = new FileInputStream(file);

        byte[] data = new byte[4096];
        int byteLen = 0;

        while ((byteLen = inputStream.read(data))!=-1){
            String content = new String(data,0,byteLen);
            System.out.println(content);
        }

        inputStream.close();
    }


    /**
     * 使用字节输入流和字节输出流实现图片拷贝
     */
    @Test
    public void testImageCopy() throws IOException {
        //1.创建字节输入流
        String path = "E:\\io\\inputstream\\美女.jpg";
        InputStream inputStream = new FileInputStream(path);

        // 创建字节输出流
        String target = "E:\\io\\outputstream\\write.jpg";
        OutputStream outputStream = new FileOutputStream(target);

        byte[] data = new byte[1024];
        int byteLen = 0;

        while ((byteLen=inputStream.read(data))!=-1){
            //将读取到的内容写入write.jpg中
            outputStream.write(data,0,byteLen);
        }

        outputStream.close();
        inputStream.close();
    }
}















