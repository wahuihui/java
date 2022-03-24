package com.hui.java.api.nio.channels;

import com.hui.java.api.net.ServerSocketConfig;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 服务端:基于AIO异步双向通讯
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/23 20:07
 * @since JDK8
 */

public class AsynchronousServerSocketChannelTest {

    public static void main(String[] args) {

        try (
                //打开一个异步服务器套接字通道
                final AsynchronousServerSocketChannel asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open()
        ){
            ServerSocketConfig serverSocketConfig = new ServerSocketConfig();
            //将异步的ServerSocketChannel绑定到9999端口上
            asynchronousServerSocketChannel.bind(new InetSocketAddress(serverSocketConfig.getPort()));

            //服务器异步接收客户端连接
            //accept方法没有阻塞
            asynchronousServerSocketChannel.accept(null,
                    new CompletionHandler<AsynchronousSocketChannel, Object>() {
                        @Override
                        public void completed(AsynchronousSocketChannel asynchronousSocketChannel, Object attachment) {
                            System.out.println("服务器:客户端连接服务器成功");
                            ByteBuffer clientRequestByteBuffer = ByteBuffer.allocate(1024);
                            asynchronousSocketChannel.read(clientRequestByteBuffer, null,
                                    new CompletionHandler<Integer, Object>() {
                                        @Override
                                        public void completed(Integer result, Object attachment) {
                                            System.out.println("服务器:服务器读取客户端请求数据已完成");
                                            //服务器处理客户端请求的数据
                                            String clientRequestData = new String(clientRequestByteBuffer.array(),0,result);
                                            System.out.println("服务器:客户端请求的数据是："+clientRequestData);

                                            String serverResponseData = "学Java特别好!";
                                            ByteBuffer serverResponseByteBuffer = ByteBuffer.allocate(1024);
                                            serverResponseByteBuffer.put(serverResponseData.getBytes());
                                            serverResponseByteBuffer.flip();
                                            asynchronousSocketChannel.write(serverResponseByteBuffer, null,
                                                    new CompletionHandler<Integer, Object>() {
                                                        @Override
                                                        public void completed(Integer result, Object attachment) {
                                                            System.out.println("服务器:服务器给客户端响应数据成功，返回的数据是："+serverResponseData);
                                                        }

                                                        @Override
                                                        public void failed(Throwable exc, Object attachment) {

                                                        }
                                                    });
                                        }

                                        @Override
                                        public void failed(Throwable exc, Object attachment) {

                                        }
                                    });
                            System.out.println("服务器:服务器读取客户端请求数据就绪");
                        }

                        @Override
                        public void failed(Throwable exc, Object attachment) {

                        }
                    });
            System.out.println("服务器:服务器准备接收客户端连接就绪");
            //为了不让服务器停止服务
            while (true){

            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}































