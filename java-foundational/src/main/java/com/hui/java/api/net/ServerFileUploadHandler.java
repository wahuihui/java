package com.hui.java.api.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务器：负责处理客户端上传的文件
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/20 20:56
 * @since JDK8
 */

public class ServerFileUploadHandler {

    /**
     * 线程池 用于处理多个客户端上传文件的请求
     */
    private static final ExecutorService executorService = Executors.newFixedThreadPool(20);

    /**
     * 处理客户端上传的文件
     */
    public void doFileUpload(){
        ServerSocketConfig serverSocketConfig = new ServerSocketConfig();

        try {
            ServerSocket serverSocket = new ServerSocket(serverSocketConfig.getPort());
            System.out.println("服务器:服务器启动成功，等待接收客户端请求");
            while (true){
                Socket socket = serverSocket.accept();
                ServerFileUploadRunnable serverFileUploadRunnable = new ServerFileUploadRunnable(socket);
                executorService.submit(serverFileUploadRunnable);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
