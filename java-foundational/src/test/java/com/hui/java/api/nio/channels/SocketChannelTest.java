package com.hui.java.api.nio.channels;

import com.hui.java.api.net.ServerSocketConfig;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * SocketChannel的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/22 17:18
 * @since JDK8
 */

public class SocketChannelTest {

    /**
     * 客户端连接服务器并给服务器发送请求数据
     * 并且打印输出服务器响应的数据
     */
    @Test
    public void testClient(){
        try (
                SocketChannel socketChannel = SocketChannel.open()
        ){
            ServerSocketConfig serverSocketConfig = new ServerSocketConfig();
            socketChannel.connect(new InetSocketAddress(serverSocketConfig.getIp(),serverSocketConfig.getPort()));

            ByteBuffer clientRequestByteBuffer = ByteBuffer.allocate(1024);
            String requestData = "今天天气怎么样？";
            clientRequestByteBuffer.put(requestData.getBytes());
            clientRequestByteBuffer.flip();
            socketChannel.write(clientRequestByteBuffer);
            System.out.println("客户端:客户端发送请求成功，请求的数据是："+requestData);

            ByteBuffer serverResponseByteBuffer = ByteBuffer.allocate(1024);
            final int serverResponseLength = socketChannel.read(serverResponseByteBuffer);
            String serverResponseData = new String(serverResponseByteBuffer.array(),0,serverResponseLength);
            System.out.println("客户端:客户端收到服务器响应信息，响应信息是："+serverResponseData);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}





















