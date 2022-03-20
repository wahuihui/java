package com.hui.java.api.net;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ServerSocket的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/20 15:01
 * @since JDK8
 */

public class ServerSocketTest {

    /**
     * 服务器接收客户端请求，然后打印输出客户端的请求数据
     */
    @Test
    public void testServerSocketV1() throws IOException {
        ServerSocketConfig serverSocketConfig = new ServerSocketConfig();
        //以6666为端口创建服务器
        ServerSocket serverSocket = new ServerSocket(serverSocketConfig.getPort());
        System.out.println("服务器:服务器启动成功，准备接收客户端请求");
        //等待客户端请求，该方法会阻塞
        final Socket socket = serverSocket.accept();
        if (null!=socket) {
            System.out.println("服务器:服务器接收客户端的请求成功，客户端的信息是："+socket);
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bufferLength = inputStream.read(buffer);
            System.out.println("服务器:客户端请求的数据内容是：" + new String(buffer, 0, bufferLength));
            socket.close();
        }
    }



    @Test
    public void testServerSocketV2() throws IOException {
        ServerSocketConfig serverSocketConfig = new ServerSocketConfig();
        //以6666为端口创建服务器
        ServerSocket serverSocket = new ServerSocket(serverSocketConfig.getPort());
        System.out.println("服务器:服务器启动成功，准备接收客户端请求");
        //等待客户端请求，该方法会阻塞
        final Socket socket = serverSocket.accept();
        if (null!=socket) {
            System.out.println("服务器:服务器接收客户端的请求成功，客户端的信息是："+socket);
            //获取客户端请求的数据
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bufferLength = inputStream.read(buffer);
            System.out.println("服务器:客户端请求的数据内容是：" + new String(buffer, 0, bufferLength));
            //服务器给客户端响应数据
            String requestData = "是的是的";

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(requestData.getBytes());
            System.out.println("服务器:服务器给客户端响应数据成功，响应的内容是："+requestData);

            socket.close();//生产环境不使用
        }
    }

}

















