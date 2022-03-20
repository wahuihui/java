package com.hui.java.api.net;

import org.testng.annotations.Test;

import java.io.*;
import java.net.Socket;

/**
 * 客户端上传文件的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/20 16:07
 * @since JDK8
 */

public class ClientFileUploadTest {

    /**
     * 客户端上传文件给服务器
     * @throws IOException 先抛出不处理
     */
    @Test
    public void testClientFileUploadV1() throws IOException {

        String localFilePath = "E:\\歌\\林俊杰 - 不能说的秘密 .flac";

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(localFilePath));
        ServerSocketConfig serverSocketConfig = new ServerSocketConfig();
        //通过指定的IP和端口连接服务器
        Socket socket = new Socket(serverSocketConfig.getIp(), serverSocketConfig.getPort());
        OutputStream outputStream = socket.getOutputStream();

        byte[] buffer = new byte[1024];
        int bufferLength;

        System.out.println("客户端:客户端开始上传文件给服务器，本地文件的磁盘路径是："+localFilePath);
        while ((bufferLength=bufferedInputStream.read(buffer))!=-1){
            outputStream.write(buffer,0,bufferLength);
        }
        //文件上传完毕后，关闭输出流，否则服务器会一直处于等待状态
        socket.shutdownOutput();
        System.out.println("客户端:客户端上传文件给服务器完成");

        socket.close();
    }

    /**
     * 客户端上传文件给服务器V2
     */
    @Test
    public void testClientFileUploadV2() throws IOException {
        String localFilePath = "E:\\歌\\林俊杰 - 不能说的秘密 .flac";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(localFilePath));

        ServerSocketConfig serverSocketConfig = new ServerSocketConfig();

        Socket socket = new Socket(serverSocketConfig.getIp(), serverSocketConfig.getPort());
        OutputStream outputStream = socket.getOutputStream();

        byte[] buffer = new byte[1024];
        int bufferLength;
        System.out.println("客户端:客户端开始上传文件给服务器，本地文件的路径是"+localFilePath);
        while ((bufferLength=bufferedInputStream.read(buffer))!=-1){
            outputStream.write(buffer,0,bufferLength);
        }

        socket.shutdownOutput();
        System.out.println("客户端:客户端结束上传文件给服务器，本地文件的路径是"+localFilePath);

        InputStream inputStream = socket.getInputStream();
        while ((bufferLength=inputStream.read(buffer))!=-1){
            System.out.println("客户端:服务器处理客户端文件上传的响应内容是："+new String(buffer,0,bufferLength));
        }
        socket.close();
    }
}


















