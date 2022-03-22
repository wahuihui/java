package com.hui.java.api.net;

import java.io.*;
import java.net.Socket;

/**
 * 处理浏览器客户端的任务
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/21 16:38
 * @since JDK8
 */

public class MultiThreadSimpleHttpServerRunnable implements Runnable {

    private static final String INDEX_PAGE = "index.html";

    final Socket socket;

    MultiThreadSimpleHttpServerRunnable(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        System.out.println("多线程服务器线程"+Thread.currentThread().getName()+"开始处理浏览器客户端的请求");

        try (
                final InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                BufferedInputStream bufferedInputStream = new
                        BufferedInputStream(MultiThreadSimpleHttpServerRunnable.class
                        .getClassLoader().getResourceAsStream("static/index.html"));

                final OutputStream outputStream = socket.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)

        ){
            final String firstLineContent = bufferedReader.readLine();
            final String[] firstLineSplitContent = firstLineContent.split(" ");

            final String pageName = firstLineSplitContent[1].substring(1);

            System.out.println("服务器:客户端请求的页面地址是："+pageName);
            if (INDEX_PAGE.equals(pageName)){
                byte[] buffer = new byte[1024];
                int byteLength;
                System.out.println("服务器:开始将"+INDEX_PAGE+"页面返回给浏览器");

                bufferedWriter.write("HTTP/1.1 200 OK");
                bufferedWriter.newLine();
                bufferedWriter.write("Content-Type:text/html");
                bufferedWriter.newLine();
                bufferedWriter.newLine();

                while ((byteLength=bufferedInputStream.read(buffer))!=-1){
                    bufferedWriter.write(new String(buffer,0,byteLength));
                }
                System.out.println("服务器:结束将"+INDEX_PAGE+"页面返回给浏览器");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("多线程服务器线程"+Thread.currentThread().getName()+"结束处理浏览器客户端的请求");
    }
}
