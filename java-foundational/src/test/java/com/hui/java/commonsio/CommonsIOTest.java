package com.hui.java.commonsio;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.*;

/**
 * commons-io组件的使用
 * commons-io官网地址  https://commons.apache.org/proper/commons-io/
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/19 18:02
 * @since JDK8
 */

public class CommonsIOTest {

    /**
     * 使用IOUtils的copy()方法实现文件拷贝
     */
    @Test
    public void testFileCopy(){
        try (
                InputStream inputStream = new FileInputStream("E:\\io\\1.flac");
                OutputStream outputStream = new FileOutputStream("E:\\io\\1_copy.flac")
        ){
            //拷贝2GB以下的使用copy方法
            IOUtils.copy(inputStream,outputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 使用commons-io提供的FileUtils的copyDirectoryToDirectory()方法实现文件夹拷贝
     */
    @Test
    public void testFileUtilsCopyDirectoryToDirectory(){
        long startTime = System.currentTimeMillis();

        File sourceDir = new File("E:\\io\\歌");
        File targetDir = new File("E:\\io\\歌2");

        try {
            FileUtils.copyDirectoryToDirectory(sourceDir,targetDir);
            long endTime = System.currentTimeMillis();
            System.out.println("FileUtils拷贝文件夹耗时："+(endTime-startTime));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用FileUtils的copyFileToDirectory()方法将指定的文件，拷贝到指定的文件夹中
     */
    @Test
    public void testFileUtilsCopyFileToDirectory(){
        File sourceFile = new File("E:\\io\\1.flac");
        File targetDir = new File("E:\\io\\歌");

        try {
            FileUtils.copyFileToDirectory(sourceFile,targetDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






















