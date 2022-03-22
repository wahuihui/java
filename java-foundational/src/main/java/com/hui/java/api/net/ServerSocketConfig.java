package com.hui.java.api.net;

/**
 * 服务器的配置
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/20 14:57
 * @since JDK8
 */

public class ServerSocketConfig {

    private Integer port = 9999;
    private String ip = "192.168.137.1";

    public Integer getPort() {
        return port;
    }

    public ServerSocketConfig setPort(Integer port) {
        this.port = port;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public ServerSocketConfig setIp(String ip) {
        this.ip = ip;
        return this;
    }
}
