package com.hui.java.api.io;

import org.testng.annotations.Test;

import java.io.*;
import java.math.BigDecimal;

/**
 * 字节缓冲流和字节流读写性能的对比
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/18 15:47
 * @since JDK8
 */

public class BufferedInputStreamBufferedOutputStreamTest {

    /**
     * 使用InputStream和OutputStream实现歌曲文件的拷贝
     */
    @Test
    public void testSongCopyWithInputStreamOutputStream(){
        long startTime = System.currentTimeMillis();

        File sourceFile = new File("E:\\io\\林俊杰 - 不能说的秘密 (Live) [mqms2].flac");
        File targetFile = new File("E:\\io\\write.flac");
        try (
                InputStream inputStream = new FileInputStream(sourceFile);
                OutputStream outputStream = new FileOutputStream(targetFile);
        ){
            byte[] buffer = new byte[1024];
            int bufLen = 0;
            while ((bufLen=inputStream.read(buffer))!=-1){
                outputStream.write(buffer,0,bufLen);
                long fileSize = targetFile.length();
                BigDecimal bigDecimal = new BigDecimal(String.valueOf(fileSize));
                BigDecimal decimal = bigDecimal.divide(new BigDecimal(String.valueOf((1024))), BigDecimal.ROUND_CEILING);
                System.out.println("当前writer.flac文件的大小是："+decimal+"KB");
            }
            long endTime = System.currentTimeMillis();
            long time = endTime-startTime;

            System.out.println("使用不带缓冲的字节流拷贝 【一次读写1024字节】 林俊杰 - 不能说的秘密 (Live) [mqms2].flac文件的耗时："+time+" 毫秒");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 使用BufferedInputStream和BufferedOutputStream实现歌曲文件的拷贝
     */
    @Test
    public void testCopySongWithBufferedInputStreamBufferedOutputStream(){
        long startTime = System.currentTimeMillis();

        File sourceFile = new File("E:\\io\\林俊杰 - 不能说的秘密 (Live) [mqms2].flac");
        File targetFile = new File("E:\\io\\write.flac");
        try (
                InputStream inputStream = new FileInputStream(sourceFile);
                OutputStream outputStream = new FileOutputStream(targetFile);

                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        ){
            byte[] buffer = new byte[1024];
            int bufLen = 0;

            while ((bufLen=bufferedInputStream.read(buffer))!=-1){
                bufferedOutputStream.write(buffer,0,bufLen);
                BigDecimal bigDecimal = new BigDecimal(String.valueOf(targetFile.length()));
                BigDecimal fileSize = bigDecimal.divide(new BigDecimal(String.valueOf((1024))), BigDecimal.ROUND_CEILING);
                System.out.println("当前writer.flac文件的大小是："+fileSize+"KB");
            }
            long endTime = System.currentTimeMillis();
            long time = endTime-startTime;

            System.out.println("使用带缓冲的字节流拷贝 【一次读写1024字节】 林俊杰 - 不能说的秘密 (Live) [mqms2].flac文件的耗时："+time+" 毫秒");
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}












