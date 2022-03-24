package com.hui.java.api.nio.channels;

import com.hui.java.api.net.ServerSocketConfig;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 客户端:基于AIO异步双向通讯
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/23 20:07
 * @since JDK8
 */

public class AsynchronousSocketChannelTest {

    public static void main(String[] args) {

        try (
                final AsynchronousSocketChannel asynchronousSocketChannel = AsynchronousSocketChannel.open()
        ){
            ServerSocketConfig serverSocketConfig = new ServerSocketConfig();
            asynchronousSocketChannel.connect(new InetSocketAddress(serverSocketConfig.getIp(), serverSocketConfig.getPort()), null,
                    new CompletionHandler<Void, Object>() {
                        @Override
                        public void completed(Void result, Object attachment) {
                            System.out.println("客户端:客户端连接服务器成功");
                            String clientRequestData = "学Java怎么样？";
                            ByteBuffer clientRequestByteBuffer = ByteBuffer.allocate(1024);
                            clientRequestByteBuffer.put(clientRequestData.getBytes());
                            clientRequestByteBuffer.flip();
                            asynchronousSocketChannel.write(clientRequestByteBuffer, null,
                                    new CompletionHandler<Integer, Object>() {
                                        @Override
                                        public void completed(Integer result, Object attachment) {
                                            System.out.println("客户端:客户端向服务器发送请求成功，请求的数据是："+clientRequestData);
                                        }

                                        @Override
                                        public void failed(Throwable exc, Object attachment) {

                                        }
                                    });
                            ByteBuffer serverResponseByteBuffer = ByteBuffer.allocate(1024);
                            asynchronousSocketChannel.read(serverResponseByteBuffer, null,
                                    new CompletionHandler<Integer, Object>() {
                                        @Override
                                        public void completed(Integer result, Object attachment) {
                                            String serverResponseData = new String(serverResponseByteBuffer.array(),0,result);
                                            System.out.println("客户端:客户端收到了服务器的响应结果，相应的结果是："+serverResponseData);
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
            System.out.println("客户端:客户端连接服务器就绪");
            while (true){

            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}





































