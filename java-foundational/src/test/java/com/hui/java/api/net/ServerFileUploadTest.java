package com.hui.java.api.net;

import org.testng.annotations.Test;

import javax.net.ServerSocketFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器文件上传的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/20 16:06
 * @since JDK8
 */

public class ServerFileUploadTest {

    /**
     * 服务器处理客户文件上传请求V1
     * @throws IOException 先抛出不处理
     */
    @Test
    public void testServerFileUploadV1() throws IOException {
        ServerSocketConfig serverSocketConfig = new ServerSocketConfig();

        //使用本机IP和6666端口创建服务器
        ServerSocket serverSocket = new ServerSocket(serverSocketConfig.getPort());
        System.out.println("服务器:服务器启动成功，等待接收客户端请求");
        //等待客户端连接
        Socket socket = serverSocket.accept();

        if (null!=socket) {
            System.out.println("服务器:服务器接收到了客户端的文件上传请求，客户端的信息是："+socket);

            InputStream inputStream = socket.getInputStream();
            String serverFilePath = "E:\\fileUpload\\write.flac";
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(serverFilePath));

            byte[] buffer = new byte[1024];
            int bufferLength;
            System.out.println("服务器:开始将本地客户端上传的文件写入到服务器的本地磁盘");
            //现象:服务器一直在读取客户端写过来的数据
            //原因：服务器不知道客户端什么时候写完数据，虽然客户端的文件上传完成了，但是如果客户端没有关闭字节输入流
            while ((bufferLength=inputStream.read(buffer))!=-1){
                bufferedOutputStream.write(buffer,0,bufferLength);
            }
            System.out.println("服务器:将本地客户端上传的文件写入到服务器的本地磁盘完成，服务器的文件磁盘路径："+serverFilePath);
        }
    }

    /**
     * 服务器处理客户端文件上传请求V2
     */
    @Test
    public void testServerFileUploadV2() throws IOException {
        ServerSocketConfig serverSocketConfig = new ServerSocketConfig();

        ServerSocket serverSocket = new ServerSocket(serverSocketConfig.getPort());
        System.out.println("服务器:服务器启动成功，等待接收客户端请求");
        //等待客户端连接
        Socket socket = serverSocket.accept();

        if (null!=socket){
            System.out.println("服务器:服务器接收到了客户端的文件上传请求，客户端的信息是："+socket);

            InputStream inputStream = socket.getInputStream();
            String serverFilePath = "E:\\fileUpload\\write.flac";
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(serverFilePath));

            byte[] buffer = new byte[1024];
            int bufferLength;
            System.out.println("服务器:开始将本地客户端上传的文件写入服务器的本地磁盘");

            while ((bufferLength=inputStream.read(buffer))!=-1){
                bufferedOutputStream.write(buffer,0,bufferLength);
            }
            System.out.println("服务器:将本地客户端上传的文件写入到服务器的本地磁盘完成，服务器的文件磁盘路径："+serverFilePath);

            //服务器处理客户端的文件成功之后给客户端响应数据
            String responseData = "文件上传成功";
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(responseData.getBytes());

            socket.shutdownOutput();
        }
    }
}















