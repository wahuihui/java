package com.hui.java.api.net;

/**
 * 多线程版简化版HTTP服务器的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/21 17:03
 * @since JDK8
 */

public class MultiThreadSimpleHttpServerTest {

    public static void main(String[] args) {
        MultiThreadSimpleHttpServer multiThreadSimpleHttpServer = new MultiThreadSimpleHttpServer();
        multiThreadSimpleHttpServer.handlerClientRequest();
    }

}
