package com.hui.java.api.net;

import java.io.*;
import java.net.Socket;

/**
 * 客户端文件上传
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/20 20:57
 * @since JDK8
 */

public class ClientFileUploadHandler {

    /**
     * 客户端文件上传
     * @param localFilePathName 本地文件路径
     */
    public void doFileUpload(String localFilePathName){

        ServerSocketConfig serverSocketConfig = new ServerSocketConfig();

        try {
            Socket socket = new Socket(serverSocketConfig.getIp(),serverSocketConfig.getPort());
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(localFilePathName.getBytes());
            System.out.println("客户端:客户端发送给服务器本地上传文件的路径成功");

            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int byteLength = inputStream.read(buffer);
            String responseData = new String(buffer,0,byteLength);

            if (null!=responseData&&!"".equals(responseData)){
                System.out.println("客户端:服务器处理客户端发送上传文件路径的响应结果是："+responseData);

                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(localFilePathName));

                System.out.println("客户端:客户端开始上传文件，文件路径："+localFilePathName);
                while((byteLength=bufferedInputStream.read(buffer))!=-1){
                    outputStream.write(buffer,0,byteLength);
                }
                System.out.println("客户端:客户端上传文件完成");
                socket.shutdownOutput();

                inputStream = socket.getInputStream();
                while ((byteLength=inputStream.read(buffer))!=-1){
                    System.out.println("客户端:服务器处理客户端上传文件的响应内容是："+new String(buffer,0,byteLength));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
