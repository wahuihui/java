package com.hui.web.foundational.dao;

import com.hui.web.foundational.bean.entity.Account;
import com.hui.web.foundational.bean.entity.bo.AccountBO;

import java.math.BigDecimal;

/**
 * 账户数据访问接口
 *
 * @author hui 1154437939@qq.com
 * @version 2022/4/1 20:29
 * @since JDK8
 */

public interface AccountDao {

    /**
     * 修改账户金额
     * @param sourceAccount 转账账户
     * @param targetAccount 收款账户
     * @return 成功/失败
     */
    boolean update(AccountBO sourceAccount,AccountBO targetAccount);

    /**
     * 查询账户余额
     * @param accountCondition 查询账户条件
     * @return 账户信息
     */
    BigDecimal select(Account accountCondition);
}
