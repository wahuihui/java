package com.hui.java.api.io;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * File类的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/13 15:03
 * @since JDK8
 */

public class FileTest {

    /**
     * File对象创建的三种方式
     */
    @Test
    public void testFileConstructor() {
        //以E:\io 路径创建File对象
        //io 文件夹不存在，也能创建File对象
        File directory = new File("E:\\io");
        System.out.println("directory = " + directory);

        File parentFile = new File("E:\\");
        String child = "io";
        File ioDirectory = new File(parentFile, child);
        System.out.println("ioDirectory = " + ioDirectory);

        String parent = "E:\\";
        File ioPath = new File(parent, child);
        System.out.println("ioPath = " + ioPath);

        //以test.txt文件的路径E:\io\text.txt创建File对象
        File file = new File("E:\\io\\test.txt");
        System.out.println("file = " + file);

        String parentPath = "E:\\io";
        String childFileName = "test.txt";
        File testFile = new File(parentPath, childFileName);
        System.out.println("testFile = " + testFile);
    }

    /**
     * 文件夹的创建和删除
     */
    @Test
    public void testDirectoryCreateDelete(){
        File directory = new File("E:\\io");
        directory.mkdir();
        directory.delete();

        File multiLevelDirectory = new File("E:\\nio\\buffer");
        multiLevelDirectory.mkdirs();
        //只能删除一级子目录，如果要删除多级目录，需要递归删除
        multiLevelDirectory.delete();
    }

    /**
     * 文件的创建和删除
     */
    @Test
    public void testFileCreateDelete() throws IOException {
        File io = new File("E:\\io");
        io.mkdir();

        //创建文件，但是指定的目录(E:\io)必须要存在
        File file = new File("E:\\io\\test.txt");
        file.createNewFile();
        file.delete();
        io.delete();
    }

    /**
     * 获取文件夹和文件的信息
     */
    @Test
    public void testGetDirectoryAndFilePath() throws IOException {
        File io = new File("E:\\io");
        io.mkdir();
        System.out.println("当前File对象表示的上一级路径：" + io.getParentFile());
        System.out.println("当前File对象表示的绝对路径：" +io.getAbsolutePath());
        System.out.println("当前File对象表示的绝对路径：" +io.getAbsoluteFile());
        System.out.println("io.getName() = " + io.getName());


        File file = new File("E:\\io\\test.txt");
        file.createNewFile();

        System.out.println("当前File对象表示的上一级路径：" + file.getParentFile());
        System.out.println("当前File对象表示的绝对路径：" +file.getAbsolutePath());
        System.out.println("当前File对象表示的绝对路径：" +file.getAbsoluteFile());
        System.out.println("file.getName() = " + file.getName());
        //只能获取文件的大小，不能获取文件夹的大小
        System.out.println("当前File对象表示文件的文件大小：" + file.length());

    }

    /**
     * 文件和文件夹判断的相关方法
     */
    @Test
    public void testFileJudge(){
        File file = new File("E:\\io\\test.txt");
        boolean exists = file.exists();
        System.out.println("E盘io目录下的test.txt文件是否存在"+exists);

        boolean isFile = file.isFile();
        System.out.println("当前File是否是文件" + isFile);

        boolean isDirectory = file.isDirectory();
        System.out.println("当前File是否是目录" + isDirectory);
    }

    /**
     * File#listFiles获取指定目录的子目录
     */
    @Test
    public void testFileList(){
        File inputStream = new File("E:\\io\\inputStream");
        File outputStream = new File("E:\\io\\outputStream");
        File reader = new File("E:\\io\\reader");
        File writer = new File("E:\\io\\writer");

        inputStream.mkdir();
        outputStream.mkdir();
        reader.mkdir();
        writer.mkdir();

        File io = new File("E:\\io");
        //获取io目录下的一级子目录
        File[] files = io.listFiles();
        System.out.println("获取io目录下的一级子目录");
        for (File file : files) {
            System.out.println(file);
        }
    }

    /**
     * File#listFiles的使用注意事项
     * 1.File关联的目录不存在，遍历子目录会引发空指针异常
     * 2.File关联的目录没有访问权限，遍历子目录会引发空指针异常
     */
    @Test
    public void testFileListFilesWarning(){
        File ioDirectory = new File("E:\\io");
        //获取E:\io下的子目录
        File[] files = ioDirectory.listFiles();

        //因为E:\io目录不存在，因为File的listFiles()方法返回空，返回空如果不进行非空判断就遍历，那就引发了空指针异常
        //因此防止空指针异常，遍历子目录前需要进行非空判断
        if (null!=files){
            for (File file : files) {
                System.out.println(file);
            }
        }

        File java = new File("E:\\Study\\java\\java-foundational\\src\\test\\java\\com\\hui\\java\\api\\lang");
        String[] javaFileLists = java.list((file, name) -> name.endsWith(".java"));

        if (null!=javaFileLists) {
            for (String javaFile : javaFileLists) {
                System.out.println(javaFile);
            }
        }
    }
}






















