package com.hui.java.api.lang;

import org.testng.annotations.Test;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * 获取进程相关信息测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/2/14 17:42
 * @since JDK8
 */

public class ProcessHandleTest  {

    @Test
    public void testGetProcessInfo(){
        Runtime runtime = Runtime.getRuntime();
        String command = "mspaint.exe";
        try {
            Process process = runtime.exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
