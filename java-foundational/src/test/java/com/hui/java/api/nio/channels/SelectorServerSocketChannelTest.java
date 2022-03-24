package com.hui.java.api.nio.channels;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 服务端:Selector实现同步非阻塞通讯
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/23 16:02
 * @since JDK8
 */

public class SelectorServerSocketChannelTest {

    public static void main(String[] args) {

        String threadName = Thread.currentThread().getName();
        try (
                //获取一个选择器
                final Selector selector = Selector.open();
                //获取多个ServerSocketChannel
                final ServerSocketChannel serverSocketChannel6666 = ServerSocketChannel.open();
                final ServerSocketChannel serverSocketChannel7777 = ServerSocketChannel.open();
                final ServerSocketChannel serverSocketChannel8888 = ServerSocketChannel.open()
        ){
            serverSocketChannel6666.bind(new InetSocketAddress(6666));
            serverSocketChannel7777.bind(new InetSocketAddress(7777));
            serverSocketChannel8888.bind(new InetSocketAddress(8888));

            //ServerSocketChannel 默认是阻塞的，因为要使用Selector实现同步非阻塞的，因此要将ServerSocketChannel设置成非阻塞的
            serverSocketChannel6666.configureBlocking(false);
            serverSocketChannel7777.configureBlocking(false);
            serverSocketChannel8888.configureBlocking(false);

            //将多个ServerSocketChannel注册到同一个选择器上
            //只能注册SelectionKey.op_ACCEPT事件 也就是接收就绪事件
            serverSocketChannel6666.register(selector, SelectionKey.OP_ACCEPT);
            serverSocketChannel7777.register(selector, SelectionKey.OP_ACCEPT);
            serverSocketChannel8888.register(selector, SelectionKey.OP_ACCEPT);

            int registeredChannelSize = selector.keys().size();
            System.out.println("服务器线程 "+threadName+" 当前选择器上注册了 "+registeredChannelSize+" 个服务器通道");

            int connectedChannelSize = selector.selectedKeys().size();
            System.out.println("服务器线程 "+threadName+" 当前选择器上客户端连接了 "+connectedChannelSize+" 个服务器通道");

            while (true){
                System.out.println("服务器线程 "+threadName+"服务器:服务器开始等待客户端连接");
                selector.select();
                System.out.println("服务器线程 "+threadName+"服务器:服务器已经接收到客户端的连接");

                connectedChannelSize = selector.selectedKeys().size();
                System.out.println("服务器线程 "+threadName+" 当前选择器上客户端连接了 "+connectedChannelSize+" 个服务器通道");

                final Set<SelectionKey> selectionKeys = selector.selectedKeys();
                final Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
                while (selectionKeyIterator.hasNext()) {
                    SelectionKey selectionKey = selectionKeyIterator.next();
                    final ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    final SocketChannel socketChannel = serverSocketChannel.accept();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    final int clientRequestLength = socketChannel.read(byteBuffer);
                    String clientRequestData = new String(byteBuffer.array(),0,clientRequestLength);
                    System.out.println("服务器线程 "+threadName+"服务器:客户端的请求是："+clientRequestData);

                    //不同请求内容响应不同结果
                    String serverResponseData = getResponseDataByRequestData(clientRequestData);

                    ByteBuffer serverResponseByteBuffer = ByteBuffer.allocate(1024);
                    serverResponseByteBuffer.put(serverResponseData.getBytes());
                    serverResponseByteBuffer.flip();
                    socketChannel.write(serverResponseByteBuffer);
                    System.out.println("服务器线程:"+threadName+"服务器:服务器给客户端的响应是："+serverResponseData);

                    //处理完成以后删除已经处理的
                    selectionKeyIterator.remove();
                }

            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static String getResponseDataByRequestData(String requestData){
        String responseData = null;
        if ("学Java怎么样？".equals(requestData)){
            responseData = "学Java特别好！";
        }else if ("学前端怎么样？".equals(requestData)){
            responseData = "学前端很棒！";
        }else if ("学Linux怎么样？".equals(requestData)){
            responseData = "学Linux非常好！";
        }
        return responseData;
    }

}
