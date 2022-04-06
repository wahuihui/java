package com.hui.web.foundational.bean.entity.bo;

import java.math.BigDecimal;

/**
 * 账户实体类扩展
 *
 * @author hui 1154437939@qq.com
 * @version 2022/4/1 20:31
 * @since JDK8
 */

public class AccountBO {
    /**
     * 账户名
     */
    private String name;
    /**
     * 转账金额
     */
    private BigDecimal transferAmount;

    public String getName() {
        return name;
    }

    public AccountBO setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public AccountBO setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
        return this;
    }
}
