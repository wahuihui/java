package com.hui.web.foundational.bean.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 账户实体类
 *
 * @author hui 1154437939@qq.com
 * @version 2022/4/1 20:26
 * @since JDK8
 */

public class Account {
    /**
     * 账户id
     */
    private Integer id;
    /**
     * 账户名
     */
    private String name;
    /**
     * 账户余额
     */
    private BigDecimal balance;
    /**
     * 账户创建时间
     */
    private Timestamp createTime;
    /**
     * 账户更新时间
     */
    private Timestamp updateTime;

    public Account() {
    }

    public Account(Integer id, String name, BigDecimal balance, Timestamp createTime, Timestamp updateTime) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public Account setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Account setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Account setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public Account setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
        return this;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public Account setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
