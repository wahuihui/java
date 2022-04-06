package com.hui.web.foundational.service.impl;

import com.hui.web.foundational.dao.AccountDao;
import com.hui.web.foundational.dao.impl.AccountDaoImpl;
import com.hui.web.foundational.service.AccountService;

import java.math.BigDecimal;

/**
 * 账户业务逻辑实现
 *
 * @author hui 1154437939@qq.com
 * @version 2022/4/1 21:30
 * @since JDK8
 */

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    @Override
    public boolean transferAmounts(String name, BigDecimal transferAmount) {
        return false;
    }
}
