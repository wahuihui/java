package com.hui.java.foundational.interfaces.service;

/**
 * 迅雷
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/11 17:24
 * @since JDK8
 */

public class Thunder {

    /**
     * 根据用户传递的URL下载数据
     * @param url
     */
    public void handleDownloadData(String url,DownloadCompleteCallBack downloadCompleteCallBack){
        System.out.println("解析地址"+url);
        System.out.println("正在下载数据...");
        String data = url;
        System.out.println(data+"已经下载完成");
        //回调
        downloadCompleteCallBack.doCompleteCallBack(data);

    }

}
