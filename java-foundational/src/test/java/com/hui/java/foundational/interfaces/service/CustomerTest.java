package com.hui.java.foundational.interfaces.service;

/**
 * 回调接口测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/11 17:44
 * @since JDK8
 */

public class CustomerTest {

    public static void main(String[] args) {

        DownloadCompleteCallBack downloadCompleteCallBack = new InstallCallBack();

        Customer tony = new Customer(downloadCompleteCallBack);
        tony.downloadData("IDEA.exe");

    }


}
