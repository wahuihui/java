package com.hui.java.api.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP地址的使用
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/19 22:07
 * @since JDK8
 */

public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {

        final InetAddress localHost = InetAddress.getLocalHost();

        System.out.println("本机的IP地址："+localHost.getHostAddress());
        System.out.println("本机的主机名称："+localHost.getHostName());

        System.out.println("通过主机名称获取本机IP地址："+InetAddress.getByName(localHost.getHostName()).getHostAddress());

        //通过 这个地址  http://110.242.68.4  也可以访问百度的首页
        System.out.println("通过百度的主机名www.baidu.com 获取百度服务器的IP地址"+InetAddress.getByName("www.baidu.com").getHostAddress());
    }
}
