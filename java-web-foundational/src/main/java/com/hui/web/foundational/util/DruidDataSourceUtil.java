package com.hui.web.foundational.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid连接池工具类
 *
 * @author hui 1154437939@qq.com
 * @version 2022/4/2 13:18
 * @since JDK8
 */

public class DruidDataSourceUtil {
    /**
     * 连接池
     */
    private static DataSource dataSource;

    /*
      读取druid.properties
     */
    static{
        Properties properties = new Properties();
        try {
            properties.load(DruidDataSourceUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            //创建Druid连接池
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池
     * @return 连接池对象
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = getDataSource().getConnection();
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
    public static void release(ResultSet resultSet, Statement statement, Connection connection){
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
