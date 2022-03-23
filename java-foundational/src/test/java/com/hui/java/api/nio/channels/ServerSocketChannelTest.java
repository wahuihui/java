package com.hui.java.api.nio.channels;

import com.hui.java.api.net.ServerSocketConfig;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * ServerSocketChannel的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/22 17:17
 * @since JDK8
 */

public class ServerSocketChannelTest {

    /**
     * 服务器接收客户端的请求并且将客户端请求的数据打印输出
     * 并且要给客户端响应 今天天气非常好，适合晒太阳
     */
    @Test
    public void testServer(){
        try (
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()
        ){
            ServerSocketConfig serverSocketConfig = new ServerSocketConfig();
            serverSocketChannel.bind(new InetSocketAddress(serverSocketConfig.getPort()));
            System.out.println("服务器:服务器启动成功，准备接收客户端请求，服务器的信息是："+serverSocketChannel);

            while (true) {
                final SocketChannel socketChannel = serverSocketChannel.accept();
                System.out.println("服务器:服务器接收到客户端的连接请求，客户端的信息是："+socketChannel);

                ByteBuffer clientRequestByteBuffer = ByteBuffer.allocate(1024);
                final int clientRequestLength = socketChannel.read(clientRequestByteBuffer);
                String clientRequestData = new String(clientRequestByteBuffer.array(),0,clientRequestLength);
                System.out.println("服务器:客户端请求的数据是："+clientRequestData);

                ByteBuffer serverResponseByteBuffer = ByteBuffer.allocate(1024);
                String serverResponseData = "今天天气非常好，适合晒太阳";
                serverResponseByteBuffer.put(serverResponseData.getBytes());
                serverResponseByteBuffer.flip();
                socketChannel.write(serverResponseByteBuffer);
                System.out.println("服务器:服务器给客户端响应，响应的数据是："+serverResponseData);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
















