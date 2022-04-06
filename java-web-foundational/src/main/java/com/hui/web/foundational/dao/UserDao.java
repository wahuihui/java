package com.hui.web.foundational.dao;

import com.hui.web.foundational.bean.entity.User;

import java.util.List;

/**
 * 用户数据访问(对数据的增删改查)接口
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/31 15:59
 * @since JDK8
 */

public interface UserDao {

    /**
     * 单引号
     */
    String singleQuotes = "'";
    /**
     * 逗号
     */
    String comma = ",";
    /**
     * mysql url
     */
    String url = "jdbc:mysql://127.0.0.1:3306/jdbc?characterEncoding=utf8";
    /**
     * mysql 账户名
     */
    String mysqlName = "root";
    /**
     * mysql 密码
     */
    String mysqlPassword = "mysql1234";

    /**
     * 新增用户
     * @param user 用户
     * @return SQl执行后受影响行数
     */
    int insert(User user);

    /**
     * 根据id或者name删除用户
     * @param userCondition 用户条件
     * @return SQl执行后受影响行数
     */
    int delete(User userCondition);

    /**
     * 根据id或者name修改用户信息
     * @param userCondition 用户条件
     * @return SQl执行后受影响行数
     */
    int update(User userCondition);

    /**
     * 查询用户
     * @param userCondition 用户条件
     * @return User对象集合
     */
    List<User> select(User userCondition);
}
