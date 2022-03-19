package com.hui.java.api.io;

import com.hui.java.foundational.interfaces.service.Cellphone;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Java语言的序列化和反序列化
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/19 11:35
 * @since JDK8
 */

public class ObjectOutputStreamObjectInputStreamTest {

    static final String path = "E:\\io\\cellphone.txt";

    /**
     * 通过ObjectOutPutStream的WriteObject()方法实现对象的序列化机制
     * 实现Cellphone对象的序列化，将Cellphone对象以字节的形式写到cellphone.txt文件中
     * Cellphone对象的数据都会以字节的方式存储到cellphone.txt文件中
     */
    @Test
    public void testObjectOutputStreamWriteObject(){
        Cellphone cellphone = new Cellphone();
        cellphone.setPrice(7299);
        cellphone.setBrand("华为");
        cellphone.setColor("黑色");
        cellphone.setModel("华为P50+ Pro");
        cellphone.setWeight(288);

        try (
                OutputStream outputStream = new FileOutputStream(path);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)
        ){
            objectOutputStream.writeObject(cellphone);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    /**
     * ObjectInputStream实现反序列化
     * 通过ObjectInputStream读取cellphone.txt文件中存储的字节信息转换为Cellphone对象
     */
    @Test
    public void testObjectInputStreamReadObject(){

        try (
                InputStream inputStream = new FileInputStream(path);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)
        ){
            Object object = objectInputStream.readObject();
            if (object instanceof Cellphone){
                Cellphone cellphone = (Cellphone) object;
                System.out.println(cellphone);
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * 集合的序列化和反序列化
     */
    @Test
    public void testCollectionSerializationDeserialization(){
        List<Cellphone> cellphoneList = new ArrayList<>();
        Cellphone huawei = new Cellphone();
        huawei.setBrand("华为");
        huawei.setWeight(228);
        huawei.setColor("黑色");
        huawei.setPrice(7299);
        huawei.setModel("华为P50 Pro+");

        Cellphone xiaomi = new Cellphone();
        xiaomi.setBrand("小米");
        xiaomi.setWeight(238);
        xiaomi.setColor("白色");
        xiaomi.setPrice(6699);
        xiaomi.setModel("小米12 Pro");

        Cellphone apple = new Cellphone();
        apple.setBrand("苹果");
        apple.setWeight(208);
        apple.setColor("绿色");
        apple.setPrice(7699);
        apple.setModel("苹果13 Pro");

        cellphoneList.add(huawei);
        cellphoneList.add(xiaomi);
        cellphoneList.add(apple);

        try (
                OutputStream outputStream = new FileOutputStream("E:\\io\\collection.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                InputStream inputStream = new FileInputStream("E:\\io\\collection.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)
        ){
            //序列化集合
            objectOutputStream.writeObject(cellphoneList);

            Object object = objectInputStream.readObject();
            if (object instanceof List){
                List<Cellphone> cPhoneList = (List<Cellphone>) object;
                System.out.println("反序列化集合后的结果：");
                for (Cellphone cellphone : cPhoneList) {
                    System.out.println(cellphone);
                }
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}





























