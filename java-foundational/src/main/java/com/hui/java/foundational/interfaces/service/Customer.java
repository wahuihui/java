package com.hui.java.foundational.interfaces.service;

/**
 * 客户
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/11 17:40
 * @since JDK8
 */

public class Customer {

    private final DownloadCompleteCallBack downloadCompleteCallBack;

    public Customer(DownloadCompleteCallBack downloadCompleteCallBack){
        this.downloadCompleteCallBack = downloadCompleteCallBack;
    }


    /**
     * 根据指定的URL下载数据
     * @param url
     */
    public void downloadData(String url){
        Thunder thunder = new Thunder();
        thunder.handleDownloadData(url,downloadCompleteCallBack);
    }

}
