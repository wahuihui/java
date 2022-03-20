package com.hui.java.api.net;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 服务器端处理客户端文件上传请求的线程任务
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/20 20:58
 * @since JDK8
 */

public class ServerFileUploadRunnable implements Runnable {

    private final Socket socket;

    public ServerFileUploadRunnable(final Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

        System.out.println("服务器线程："+Thread.currentThread().getName()+" 开始处理文件上传任务");
        try {
            if (null!=socket){
                System.out.println("服务器:服务器接收到了客户端的文件上传请求，客户端的信息是："+socket);

                InputStream inputStream = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int byteLength=inputStream.read(buffer);
                String localFilePathName = new String(buffer, 0, byteLength);

                OutputStream outputStream = socket.getOutputStream();
                String responseData = "服务器已经接收到了客户端上传文件本地路径，本地路径是："+localFilePathName;
                outputStream.write(responseData.getBytes());

                String serverFilePathName = generatorServerFilePathName(localFilePathName);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(serverFilePathName));

                System.out.println("服务器:开始将本地客户端上传的文件写到："+serverFilePathName);
                while ((byteLength=inputStream.read(buffer))!=-1){
                    bufferedOutputStream.write(buffer,0,byteLength);
                }
                System.out.println("服务器:将本地客户端上传的文件写到："+serverFilePathName+"完成");

                responseData = "服务器处理客户端上传的文件处理成功";
                outputStream.write(responseData.getBytes());

                socket.shutdownOutput();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("服务器线程："+Thread.currentThread().getName()+" 结束处理文件上传任务");
    }

    /**
     * 根据客户端上传文件的本地磁盘路径 生成服务器的磁盘路径
     * @param localFilePathName  客户端上传文件的本地磁盘路径
     * @return 服务器的磁盘路径
     */
    public String generatorServerFilePathName(String localFilePathName){

        StringBuffer serverFilePathName = new StringBuffer("E:\\fileUpload\\");

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH,mm,ss,SS");

        serverFilePathName.append(localDateTime.format(dateFormatter)).append("\\");

        File file = new File(serverFilePathName.toString());
        if (!file.exists()){
            file.mkdirs();
        }

        serverFilePathName.append(localDateTime.format(timeFormatter));

        String suffixName = localFilePathName.substring(localFilePathName.lastIndexOf("."));
        serverFilePathName.append(suffixName);

        return serverFilePathName.toString();
    }
}
