package com.hui.java.api.net;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Socket的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/20 15:10
 * @since JDK8
 */

public class SocketTest {

    /**
     * 客户端向服务器发送请求数据
     * @throws IOException
     */
    @Test
    public void testSocketV1() throws IOException {
        ServerSocketConfig serverSocketConfig = new ServerSocketConfig();
        //创建客户端并且连接指定IP和端口的服务器，前提条件是服务器已经提前启动，否则会连接失败
        Socket socket = new Socket(serverSocketConfig.getIp(), serverSocketConfig.getPort());
        OutputStream outputStream = socket.getOutputStream();
        String requestData = "是不是王澳辉的服务器？";
        outputStream.write(requestData.getBytes());
        System.out.println("客户端:客户端给服务器发送请求数据成功，请求的数据内容是："+requestData);
        socket.close();
    }

    @Test
    public void testSocketV2() throws IOException {
        ServerSocketConfig serverSocketConfig = new ServerSocketConfig();
        //创建客户端并且连接指定IP和端口的服务器，前提条件是服务器已经提前启动，否则会连接失败
        Socket socket = new Socket(serverSocketConfig.getIp(), serverSocketConfig.getPort());
        OutputStream outputStream = socket.getOutputStream();
        String requestData = "是不是王澳辉的服务器？";
        outputStream.write(requestData.getBytes());
        System.out.println("客户端:客户端给服务器发送请求数据成功，请求的数据内容是："+requestData);

        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int bufferLength = inputStream.read(buffer);
        System.out.println("客户端:服务器响应的数据内容是："+new String(buffer,0,bufferLength));
        socket.close();
    }

}


















