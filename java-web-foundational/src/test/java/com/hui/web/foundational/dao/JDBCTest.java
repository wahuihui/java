package com.hui.web.foundational.dao;

import com.mysql.cj.jdbc.Driver;
import org.testng.annotations.Test;

import java.sql.*;

/**
 * JDBC编程
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/31 13:29
 * @since JDK8
 */

public class JDBCTest {

    /**
     * 使用JDBC API 查询jdbc_user表的数据
     */
    @Test
    public void testSelectJDBCUserTableData(){
        String url = "jdbc:mysql://localhost:3306/jdbc?characterEncoding=utf8";
        String mysqlName = "root";
        String mysqlPassword = "mysql1234";

        try {
            //1.注册驱动
            DriverManager.registerDriver(new Driver());
            //2.获得连接
            Connection connection = DriverManager.getConnection(url,mysqlName,mysqlPassword);
            //3.获取执行SQL语句的对象
            Statement statement = connection.createStatement();
            //4.执行SQL获取返回结果得到结果集
            ResultSet resultSet = statement.executeQuery("select * from jdbc_user");

            //5.处理结果
            while(resultSet.next()){
                //获取表中的记录 循环一次就是获取一条记录
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Timestamp create_time = resultSet.getTimestamp("create_time");
                Timestamp update_time = resultSet.getTimestamp("update_time");
                //打印查询jdbc_user表中的数据
                System.out.println("id: "+id+"\tname: "+name+"\tcreate_time: "+create_time+
                        "\tupdate_time: "+update_time);
            }
            //6.关闭资源
            if (resultSet!=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用JDBC API 查询jdbc_user 表的数据
     * 使用try-with-resources自动关闭资源
     */
    @Test
    public void testSelectJDBCUserTableDataTryResourceV1(){
        String url = "jdbc:mysql://localhost:3306/jdbc?characterEncoding=utf8";
        String mysqlName = "root";
        String mysqlPassword = "mysql1234";
        try (
                Connection connection = DriverManager.getConnection(url,mysqlName,mysqlPassword);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from jdbc_user")
        ){
            DriverManager.registerDriver(new Driver());
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                Timestamp createTime = resultSet.getTimestamp("create_time");
                Timestamp updateTime = resultSet.getTimestamp("update_time");

                System.out.println("id: "+id+"\tname: "+name+"\tpassword: "+password+
                        "\ncreateTime: "+createTime+"\tupdateTime: "+ updateTime);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }



    @Test
    public void testSelectJDBCUserTableDataTryResourceV2(){
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc?characterEncoding=utf8";
        String userName = "root";
        String userPassword = "mysql1234";
        try (
                Connection connection = DriverManager.getConnection(url,userName,userPassword);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from jdbc_user")
        ){
            Class.forName("com.mysql.cj.jdbc.Driver");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                Timestamp createTime = resultSet.getTimestamp("create_time");
                Timestamp updateTime = resultSet.getTimestamp("update_time");

                System.out.println("id: "+id+"\tname: "+name+"\tpassword: "+password+
                        "\ncreateTime: "+createTime+"\tupdateTime: "+ updateTime);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}




