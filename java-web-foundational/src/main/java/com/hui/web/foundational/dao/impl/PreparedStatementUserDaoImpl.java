package com.hui.web.foundational.dao.impl;

import com.hui.web.foundational.bean.entity.User;
import com.hui.web.foundational.dao.UserDao;
import com.hui.web.foundational.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 基于PreparedStatement实现的用户的信息的增删改查，使用JDBC工具类
 *
 * @author hui 1154437939@qq.com
 * @version 2022/4/1 15:00
 * @since JDK8
 */

public class PreparedStatementUserDaoImpl implements UserDao {
    @Override
    public int insert(User user) {
        if (null != user && user.getName() != null && user.getPassword() != null) {
            String sql = "insert into jdbc_user values(null,?,?,now(),now())";
            try (
                    Connection connection = JDBCUtil.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ) {
                preparedStatement.setString(1,user.getName());
                preparedStatement.setString(2,user.getPassword());
                int row = preparedStatement.executeUpdate();
                return row;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public int delete(User userCondition) {
        String sql = null;
        if (null!=userCondition&&userCondition.getId()!=null){
            sql = "delete from jdbc_user where id =?";
        }else if (null!=userCondition&&userCondition.getName()!=null){
            sql = "delete from jdbc_user where name = ?";
        }
        try (
                Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            if (null!=userCondition&&userCondition.getId()!=null) {
                preparedStatement.setInt(1,userCondition.getId());
            }else if (null!=userCondition&&userCondition.getName()!=null){
                preparedStatement.setString(1,userCondition.getName());
            }
            int row = preparedStatement.executeUpdate();
            return row;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(User userCondition) {
        String sql = null;
        if (null!=userCondition&&userCondition.getId()!=null){
            sql = "update jdbc_user set name = ? where id = ?";
        }else if (null!=userCondition&&userCondition.getName()!=null){
            sql = "update jdbc_user set password = ? where name = ?";
        }

        try (
                Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            if (null!=userCondition&&userCondition.getId()!=null) {
                preparedStatement.setString(1,userCondition.getName());
                preparedStatement.setInt(2,userCondition.getId());
            }else if (null!=userCondition&&userCondition.getName()!=null) {
                preparedStatement.setString(1,userCondition.getPassword());
                preparedStatement.setString(2, userCondition.getName());
            }
            int row = preparedStatement.executeUpdate();
            return row;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<User> select(User userCondition) {
        String sql = null;
        if (null==userCondition){
            sql = "select * from jdbc_user";
        }else if (null!=userCondition&&userCondition.getId()!=null){
            sql = "select * from jdbc_user where id=?";
        }else if (null!=userCondition&&userCondition.getName()!=null&&userCondition.getPassword()!=null){
            sql = "select * from jdbc_user where name = ? and password = ?";
        }
        try (
                Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            if (null!=sql&&sql!="") {
                if (null!=userCondition&&userCondition.getId() != null) {
                    preparedStatement.setInt(1, userCondition.getId());
                } else if (null!=userCondition&&userCondition.getName() != null&&userCondition.getPassword()!=null) {
                    preparedStatement.setString(1, userCondition.getName());
                    preparedStatement.setString(2, userCondition.getPassword());

                }
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> userList = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                Timestamp createTime = resultSet.getTimestamp("create_time");
                Timestamp updateTime = resultSet.getTimestamp("update_time");
                User user = new User(id,name,password,createTime.toLocalDateTime(),updateTime.toLocalDateTime());
                userList.add(user);
            }
            return userList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
