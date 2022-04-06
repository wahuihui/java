package com.hui.web.foundational.dao.impl;

import com.hui.web.foundational.bean.entity.User;
import com.hui.web.foundational.dao.UserDao;
import com.hui.web.foundational.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 基于Statement实现用户的增删改查操作
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/31 16:14
 * @since JDK8
 */

public class StatementUserDaoImpl implements UserDao {

    @Override
    public int insert(User user) {
        if (user!=null&&user.getName()!=null&&user.getPassword()!=null){
            String name = user.getName();
            String password = user.getPassword();

            String sql = "insert into jdbc_user values(null,"+singleQuotes+name+singleQuotes+comma+singleQuotes+password+singleQuotes+",now(),now())";
            //2.获得连接
            try (
                    Connection connection = JDBCUtil.getConnection();
                    //3.获取执行SQL的Statement对象
                    Statement statement = connection.createStatement();
            ){
                System.out.println("新增用户执行的SQL语句是："+sql);
                //4.执行SQL并获取返回结果
                int row = statement.executeUpdate(sql);
                //5.处理结果
                return row;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public int delete(User userCondition) {
        String sql = null;
        //根据id删除
        if (null!=userCondition&&userCondition.getId()!=null){
            sql = "delete from jdbc_user where id="+userCondition.getId();
        }
        //根据name删除
        else if (null!=userCondition&& userCondition.getName()!=null){
            sql = "delete from jdbc_user where name="+singleQuotes+userCondition.getName()+singleQuotes;
        }
        try (
                Connection connection = JDBCUtil.getConnection();
                Statement statement = connection.createStatement();
        ){
            System.out.println("删除用户执行的SQL语句是："+sql);
            if (sql!=null&&sql!=""){
                int row = statement.executeUpdate(sql);
                return row;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(User userCondition) {
        String sql = null;
        //通过id修改name
        if (null!=userCondition&&userCondition.getId()!=null&&userCondition.getName()!=null){
            sql = "update jdbc_user set name="+singleQuotes+userCondition.getName()+singleQuotes+"where id="+userCondition.getId();
        }
        //通过name修改password
        else if (null!=userCondition&&userCondition.getName()!=null&&userCondition.getPassword()!=null){
            sql = "update jdbc_user set password="+singleQuotes+userCondition.getPassword()+singleQuotes+"where name="+singleQuotes+userCondition.getName()+singleQuotes;
        }

        try (
                Connection connection = JDBCUtil.getConnection();
                Statement statement = connection.createStatement()
        ){
            if (null!=sql&&sql!="") {
                System.out.println("执行修改用户的SQL语句是：" + sql);

                int row = statement.executeUpdate(sql);
                return row;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<User> select(User userCondition) {
        String sql = null;
        /****************************拼接SQL**********************************/
        //查询所有
        if (userCondition==null){
            sql = "select * from jdbc_user";
        }
        //根据id查询
        else if (null!=userCondition&&userCondition.getId()!=null){
            sql = "select * from jdbc_user where id="+userCondition.getId();
        }
        //根据name和password查询
        else if (null!=userCondition&&userCondition.getName()!=null&&userCondition.getPassword()!=null){
            sql = "select * from jdbc_user where name="+singleQuotes+userCondition.getName()+
                    singleQuotes+"and password="+singleQuotes+userCondition.getPassword()+singleQuotes;
        }

        try (
                Connection connection = JDBCUtil.getConnection();
                Statement statement = connection.createStatement()
        ){
            if (null!=sql&&sql!="") {
                System.out.println("执行查询用户的SQL语句是："+sql);
                ResultSet resultSet = statement.executeQuery(sql);
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
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}











