package com.hui.java.api.net;

import org.testng.annotations.Test;

/**
 * 服务器接收文件的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/20 22:09
 * @since JDK8
 */

public class ServerFileUploadHandlerTest {

    @Test
    public void testServerDoFileUpload(){
        ServerFileUploadHandler serverFileUploadHandler = new ServerFileUploadHandler();
        serverFileUploadHandler.doFileUpload();
    }
}
