package com.hui.java.api.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 简化版的HTTP服务器
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/21 15:20
 * @since JDK8
 */

public class SimpleHttpServer {

    private static final String INDEX_PAGE = "index.html";

    /**
     * 服务器处理客户端请求
     */
    public void handlerClientRequest() {
        while (true) {
            ServerSocketConfig serverSocketConfig = new ServerSocketConfig();
            try (
                    ServerSocket serverSocket = new ServerSocket(serverSocketConfig.getPort());
                    Socket socket = serverSocket.accept();
                    final InputStream inputStream = socket.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                    BufferedInputStream bufferedInputStream = new
                            BufferedInputStream(SimpleHttpServer.class.getClassLoader()
                            .getResourceAsStream("static/index.html"));

                    final OutputStream outputStream = socket.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)
            ) {

                final String firstLineContent = bufferedReader.readLine();

                final String[] firstLineSplitContent = firstLineContent.split(" ");
                final String pageName = firstLineSplitContent[1].substring(1);

                System.out.println("服务器:客户端请求的页面地址是：" + pageName);

                if (INDEX_PAGE.equals(pageName)) {
                    byte[] buffer = new byte[1024];
                    int byteLength;
                    System.out.println("服务器:开始将" + INDEX_PAGE + "页面返回给浏览器");
                    bufferedWriter.write("HTTP/1.1 200 OK");
                    bufferedWriter.newLine();
                    bufferedWriter.write("Content-Type:text/html");
                    bufferedWriter.newLine();
                    bufferedWriter.newLine();

                    while ((byteLength = bufferedInputStream.read(buffer)) != -1) {
                        bufferedWriter.write(new String(buffer, 0, byteLength));
                    }
                    System.out.println("服务器:结束将" + INDEX_PAGE + "页面返回给浏览器");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}









