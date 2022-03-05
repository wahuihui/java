package com.hui.java.foundational.interfaces.service;

/**
 * 安装回调
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/11 17:30
 * @since JDK8
 */

public class InstallCallBack implements DownloadCompleteCallBack {

    private static final String SOFT = "IDEA.exe";

    @Override
    public void doCompleteCallBack(String data) {
        System.out.println("迅雷下载到的数据是："+data);
        if (SOFT.equals(data)){
            System.out.println("用户执行安装"+data);
        }
    }
}
