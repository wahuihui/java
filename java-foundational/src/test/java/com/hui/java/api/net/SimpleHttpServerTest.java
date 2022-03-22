package com.hui.java.api.net;


/**
 * 简化版的HTTP服务器的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/21 15:34
 * @since JDK8
 */

public class SimpleHttpServerTest {

    public static void main(String[] args) {
        SimpleHttpServer simpleHttpServer = new SimpleHttpServer();
        simpleHttpServer.handlerClientRequest();
    }
}
