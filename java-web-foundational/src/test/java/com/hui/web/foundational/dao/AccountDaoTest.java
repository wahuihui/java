package com.hui.web.foundational.dao;

import com.hui.web.foundational.bean.entity.Account;
import com.hui.web.foundational.bean.entity.bo.AccountBO;
import com.hui.web.foundational.dao.impl.AccountDaoImpl;
import org.testng.annotations.Test;

import java.math.BigDecimal;

/**
 * 账户数据访问接口实现的测试
 *
 * @author hui 1154437939@qq.com
 * @version 2022/4/1 21:11
 * @since JDK8
 */

public class AccountDaoTest {

    private final AccountDao accountDao = new AccountDaoImpl();

    @Test
    public void testUpdate(){
        BigDecimal transferAmount = new BigDecimal("100000");
        AccountBO sourceAccountBO = new AccountBO();
        sourceAccountBO.setName("jack");
        sourceAccountBO.setTransferAmount(transferAmount);

        AccountBO targetAccountBo = new AccountBO();
        targetAccountBo.setName("tony");
        targetAccountBo.setTransferAmount(transferAmount);
        boolean transferAmountResult = accountDao.update(sourceAccountBO, targetAccountBo);
        System.out.println(transferAmountResult?"转账成功":"转账失败");
    }

    @Test
    public void testSelect(){
        Account account = new Account();
        account.setName("tony");
        BigDecimal balance = accountDao.select(account);
        System.out.println(balance);
    }
}
