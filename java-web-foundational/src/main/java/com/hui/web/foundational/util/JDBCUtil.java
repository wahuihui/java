package com.hui.web.foundational.util;


import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/31 18:56
 * @since JDK8
 */

public final class JDBCUtil {
    private static String url;
    private static String name;
    private static String password;
    private static String driver;

    static{
        Properties properties = new Properties();
        try {
            properties.load(JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            url = properties.getProperty("url");
            name = properties.getProperty("name");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");

            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取数据库连接
     * @return 连接
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,name,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 数据库操作释放资源
     * @param resultSet 结果集
     * @param statement 声明
     * @param connection 连接
     */
    public static void release(ResultSet resultSet, Statement statement,Connection connection){
        if (null!=resultSet){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null!=statement){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null!=connection){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
