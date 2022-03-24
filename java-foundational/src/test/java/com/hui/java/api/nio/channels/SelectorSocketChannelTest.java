package com.hui.java.api.nio.channels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 客户端:Selector实现同步非阻塞通讯
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/23 16:03
 * @since JDK8
 */

public class SelectorSocketChannelTest {

    public static void main(String[] args) {

        Map<Integer,String> map = new HashMap<>();
        map.put(6666,"学Java怎么样？");
        map.put(7777,"学前端怎么样？");
        map.put(8888,"学Linux怎么样？");

        final Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> serverPortMessageEntry : entrySet) {

            Integer serverPort = serverPortMessageEntry.getKey();
            final String clientRequestData = serverPortMessageEntry.getValue();

            try (
                    final SocketChannel socketChannel = SocketChannel.open()
            ){
                socketChannel.connect(new InetSocketAddress(serverPort));
                System.out.println("客户端:客户端连接 "+serverPort+" 端口的服务器");

                //给多个不同的服务器端口发送请求
                ByteBuffer clientRequestByteBuffer = ByteBuffer.allocate(1024);
                clientRequestByteBuffer.put(clientRequestData.getBytes());
                clientRequestByteBuffer.flip();
                socketChannel.write(clientRequestByteBuffer);
                System.out.println("客户端:客户端发送请求给："+serverPort+" 的服务器，请求的内容是："+clientRequestData);


                ByteBuffer serverResponseByteBuffer = ByteBuffer.allocate(1024);
                final int serverResponseLength = socketChannel.read(serverResponseByteBuffer);
                String serverResponseData = new String(serverResponseByteBuffer.array(),0,serverResponseLength);
                System.out.println("客户端:服务器响应的数据是："+serverResponseData);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}















