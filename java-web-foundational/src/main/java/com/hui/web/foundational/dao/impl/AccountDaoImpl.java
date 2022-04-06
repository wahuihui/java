package com.hui.web.foundational.dao.impl;

import com.hui.web.foundational.bean.entity.Account;
import com.hui.web.foundational.bean.entity.bo.AccountBO;
import com.hui.web.foundational.dao.AccountDao;
import com.hui.web.foundational.util.DruidDataSourceUtil;
import com.hui.web.foundational.util.JDBCUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 账户数据访问接口实现
 *
 * @author hui 1154437939@qq.com
 * @version 2022/4/1 20:38
 * @since JDK8
 */

public class AccountDaoImpl implements AccountDao {

    @Override
    public boolean update(AccountBO sourceAccount, AccountBO targetAccount) {
        Connection connection = null;
        PreparedStatement sourcePreparedStatement = null;
        PreparedStatement targetPreparedStatement = null;
        String sourceAccountSql = null;
        String targetAccountSql = null;
        if (null != sourceAccount && sourceAccount.getName() != null && sourceAccount.getTransferAmount() != null) {
            sourceAccountSql = "update jdbc_account set balance = balance - ? where name = ?";
        }
        if (null != targetAccount && targetAccount.getName() != null && targetAccount.getTransferAmount() != null) {
            targetAccountSql = "update jdbc_account set balance = balance + ? where name = ?";
        }
        try {
            //connection = JDBCUtil.getConnection();
            connection = DruidDataSourceUtil.getConnection();
            connection.setAutoCommit(false);
            sourcePreparedStatement = connection.prepareStatement(sourceAccountSql);
            targetPreparedStatement = connection.prepareStatement(targetAccountSql);
            BigDecimal transferAmount = sourceAccount.getTransferAmount();
            if (null != sourceAccountSql && sourceAccountSql != "") {
                if (null != sourceAccount && sourceAccount.getName() != null && sourceAccount.getTransferAmount() != null) {
                    sourcePreparedStatement.setBigDecimal(1, transferAmount);
                    sourcePreparedStatement.setString(2, sourceAccount.getName());
                    int row = sourcePreparedStatement.executeUpdate();
                    if (row == 1) {
                        if (null != targetAccountSql && targetAccountSql != "") {
                            if (null != targetAccount && targetAccount.getName() != null && targetAccount.getTransferAmount() != null) {
                                targetPreparedStatement.setBigDecimal(1, transferAmount);
                                targetPreparedStatement.setString(2, targetAccount.getName());
                                row = targetPreparedStatement.executeUpdate();
                                if (row == 1) {
                                    connection.commit();
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
                System.out.println("转账失败，事务回滚");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            DruidDataSourceUtil.release(null, sourcePreparedStatement, connection);
            DruidDataSourceUtil.release(null, targetPreparedStatement, connection);
            System.out.println("释放数据库资源完成");
        }
        return false;
    }

    @Override
    public BigDecimal select(Account accountCondition) {
        String sql = null;
        if (null != accountCondition && accountCondition.getName() != null) {
            sql = "select balance from jdbc_account where name = ?";
        }
        try (
                Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            if (null != sql && sql != "") {
                if (null != accountCondition && accountCondition.getName() != null) {
                    preparedStatement.setString(1, accountCondition.getName());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        BigDecimal balance = resultSet.getBigDecimal("balance");
                        return balance;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
