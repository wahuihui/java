package com.hui.web.foundational.service;

import java.math.BigDecimal;

/**
 * 账户业务逻辑
 *
 * @author hui 1154437939@qq.com
 * @version 2022/4/1 21:25
 * @since JDK8
 */

public interface AccountService {

    /**
     * 转账业务
     * @param name 收款账户名
     * @param transferAmount 转账金额
     * @return 转账成功/失败
     */
    boolean transferAmounts(String name, BigDecimal transferAmount);
}
