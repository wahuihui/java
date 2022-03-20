package com.hui.java.api.net;

import org.testng.annotations.Test;

/**
 * 客户端上传文件的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/20 22:09
 * @since JDK8
 */

public class ClientFileUploadHandlerTest {

    @Test
    public void testDoFileUpload(){
        ClientFileUploadHandler clientFileUploadHandler = new ClientFileUploadHandler();
        clientFileUploadHandler.doFileUpload("E:\\歌\\林俊杰 - 不能说的秘密 .flac");
    }

    @Test
    public void testDoFileUpload1(){
        ClientFileUploadHandler clientFileUploadHandler = new ClientFileUploadHandler();
        clientFileUploadHandler.doFileUpload("E:\\歌\\林俊杰 - 女儿情 (Live).flac");
    }

    @Test
    public void testDoFileUpload2(){
        ClientFileUploadHandler clientFileUploadHandler = new ClientFileUploadHandler();
        clientFileUploadHandler.doFileUpload("E:\\歌\\林俊杰 - 不能说的秘密 .flac");
    }


}
