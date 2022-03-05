package com.hui.java.foundational.interfaces.service;

/**
 * 读取文件回调
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/11 17:38
 * @since JDK8
 */

public class ReadCallBack implements DownloadCompleteCallBack {
    @Override
    public void doCompleteCallBack(String data) {
        System.out.println("下载的数据是："+data);
        System.out.println("用户正在使用PDF工具阅读"+data);
    }
}
