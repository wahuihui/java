package com.hui.web.foundational.util;

import javax.sql.DataSource;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义QueryRunner
 *
 * @author hui 1154437939@qq.com
 * @version 2022/4/2 18:18
 * @since JDK8
 */

public class CustomQueryRunner {
    /**
     * 下划线
     */
    private static final String UNDER_LINE = "_";
    /**
     * 连接池
     */
    final DataSource dataSource;

    public CustomQueryRunner(final DataSource dataSource){
        this.dataSource = dataSource;
    }

    /**
     * 数据的增删改
     * @param sql sql语句
     * @param params 要操作的数据
     * @return 受影响行数
     */
    public int update(String sql,Object...params){
        if (null!=dataSource&&null!=sql&&sql!=""){
            try (
                    Connection connection = dataSource.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(sql)
            ){
                //获取SQL参数的元数据
                ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
                int parameterCount = parameterMetaData.getParameterCount();
                //给占位的参数设值
                for (int i = 1; i <= parameterCount; i++) {
                    preparedStatement.setObject(i,params[i-1]);
                }
                int row = preparedStatement.executeUpdate();
                return row;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return -1;
    }

    /**
     * 查询结果是单行单列
     * @param sql SQL语句
     * @param clazz 类
     * @param params 要操作的数据
     * @param <T> 泛型类型
     * @return 要返回的类型
     */
    public <T> T queryForType(String sql,Class<T> clazz,Object...params){
        if (null!=dataSource&&null!=sql&&sql!=""){
            try (
                    Connection connection = dataSource.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(sql)
            ){
                //获取SQL参数的元数据
                ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
                for (int i = 1; i <= parameterMetaData.getParameterCount(); i++) {
                    preparedStatement.setObject(i,params);
                }
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    T object = resultSet.getObject(1, clazz);
                    return object;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 查询结果是一条记录(单行多列)
     * 一条记录对应Java中的一个对象
     *
     * @param sql sql条件语句
     * @param clazz  对象类型
     * @param params 查询条件的参数
     * @param <T>    泛型类型
     * @return 返回类型是一个泛型类型
     */
    public <T> T queryForObject(String sql,Class<T> clazz,Object...params){
        if (null!=dataSource&&null!=sql&&sql!=""){
            try (
                    Connection connection = dataSource.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(sql)
            ){
                //获取SQL参数的元数据
                ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
                //给占位的参数设值
                for (int i = 1; i <= parameterMetaData.getParameterCount(); i++) {
                    preparedStatement.setObject(i,params[i-1]);
                }
                ResultSet resultSet = preparedStatement.executeQuery();
                T instance = null;
                while (resultSet.next()){
                    instance = clazz.newInstance();
                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                    int columnCount = resultSetMetaData.getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = resultSetMetaData.getColumnName(i);
                        Method[] allPublicMethods = clazz.getMethods();
                        for (Method publicMethod : allPublicMethods) {
                            String filedName = publicMethod.getName();
                            if (filedName.contains("set")){
                                if (compareColumnNameFiledName(columnName,filedName)){
                                    publicMethod.invoke(instance,resultSet.getObject(i));
                                }
                            }
                        }
                    }
                }
                return instance;
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * 将原列名，原字段名都转小写后比较是否相同
     * @param originColumnName 原列名
     * @param filedName 字段名
     * @return 转化后的列名和字段名是否相同
     */
    private static boolean compareColumnNameFiledName(String originColumnName,String filedName){
        String subFiledName = filedName.substring(3);
        String lowerCaseFiledName = subFiledName.toLowerCase();
        String lowerCaseColumnName = "";
        if (originColumnName.contains(UNDER_LINE)){
            String[] splitColumnNames = originColumnName.split(UNDER_LINE);
            String columnName = "";
            for (int i = 0; i < splitColumnNames.length; i++) {
                columnName = columnName + splitColumnNames[i];
            }
            lowerCaseColumnName = columnName.toLowerCase();
        }else {
            lowerCaseColumnName = originColumnName.toLowerCase();
        }

        if (lowerCaseFiledName.equals(lowerCaseColumnName)){
            return true;
        }else {
            return false;
        }
    }


    /**
     * 查询多条记录
     * @param sql sql语句
     * @param clazz 对象类型
     * @param params 查询条件的参数
     * @param <T> 泛型类型
     * @return 对象集合
     */
    public <T> List<T> queryForList(String sql,Class<T> clazz,Object...params){
        if (null!=dataSource&&null!=sql&&sql!=""){
            try (
                    Connection connection = dataSource.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(sql)
            ){
                ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
                for (int i = 1; i <= parameterMetaData.getParameterCount(); i++) {
                    preparedStatement.setObject(i,params[i-1]);
                }
                ResultSet resultSet = preparedStatement.executeQuery();
                List<T> objectsList = new ArrayList<>();
                while (resultSet.next()){
                    T object = clazz.newInstance();
                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                    int columnCount = resultSetMetaData.getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = resultSetMetaData.getColumnName(i);
                        Method[] allPublicMethods = clazz.getMethods();
                        for (Method publicMethod : allPublicMethods) {
                            String methodName = publicMethod.getName();
                            if (methodName.contains("set")){
                                if (compareColumnNameFiledName(columnName,methodName)){
                                    publicMethod.invoke(object, resultSet.getObject(i));
                                }
                            }
                        }
                    }
                    if (null!=object){
                        objectsList.add(object);
                    }
                }
                if (null!=objectsList&&objectsList.size()>0) {
                    return objectsList;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

}
