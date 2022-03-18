package com.hui.java.api.io;

import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 转换流的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/18 21:05
 * @since JDK8
 */

public class InputStreamReaderOutputStreamWriterTest {

    /**
     * 读取GBK编码的文件
     * 会有乱码问题
     */
    @Test
    public void testReaderGBKFile(){

        try (
                Reader reader = new FileReader("E:\\io\\gbk.txt")
        ){
            char[] buffer = new char[1024];
            int bufLen;
            while ((bufLen=reader.read(buffer))!=-1){
                System.out.println(new String(buffer,0,bufLen));
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 使用InputStreamReader读取GBK文件
     */
    @Test
    public void testInputStreamReaderReadGBKFile(){
        try (
                InputStream inputStream = new FileInputStream("E:\\io\\gbk.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("GBK"));
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ){
            String content;
            while ((content= bufferedReader.readLine())!=null){
                System.out.println(content);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 使用OutputStreamWriter实现按照指定编码来写文件
     */
    @Test
    public void testOutputStreamWriterWriteUTF8File(){
        try (
                OutputStream outputStream = new FileOutputStream("E:\\io\\utf-8.txt");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)
        ){
            bufferedWriter.write("好好学习");
            bufferedWriter.newLine();
            bufferedWriter.write("天天向上");
            bufferedWriter.newLine();
            bufferedWriter.write("哈哈哈哈");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 将GBK编码的gbk.txt文件编码转换成UTF-8
     */
    @Test
    public void testFileEncodingConvert(){
        try (
                InputStream inputStream = new FileInputStream("E:\\io\\gbk.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"GBK");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ){
            String content;
            List<String> list = new ArrayList<>();
            while ((content=bufferedReader.readLine())!=null){
                list.add(content);
            }

            OutputStream outputStream = new FileOutputStream("E:\\io\\gbk.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            for (String convertedEncodingContent : list) {
                bufferedWriter.write(convertedEncodingContent);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}





















