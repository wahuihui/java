package com.hui.java.foundational.interfaces.service;

/**
 * 下载完成回调
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/11 17:27
 * @since JDK8
 */

public interface DownloadCompleteCallBack {

    /**
     * 迅雷下载完成后相关处理(回调)
     * @param data 下载的数据
     */
    void doCompleteCallBack(String data);

}
