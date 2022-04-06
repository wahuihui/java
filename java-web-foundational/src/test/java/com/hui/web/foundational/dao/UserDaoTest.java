package com.hui.web.foundational.dao;

import com.hui.web.foundational.bean.entity.User;
import com.hui.web.foundational.dao.impl.PreparedStatementUserDaoImpl;
import com.hui.web.foundational.util.CustomQueryRunner;
import com.hui.web.foundational.util.DruidDataSourceUtil;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * 用户数据访问接口的测试
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/31 16:31
 * @since JDK8
 */

public class UserDaoTest {

    private final UserDao userDao = new PreparedStatementUserDaoImpl();

    @BeforeClass
    public void getUserDaoImpl(){
        System.out.println("当前userDao的实现类是："+userDao.getClass());
    }

    /**
     * 测试新增用户
     */
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("jack");
        user.setPassword("666666");
        int row = userDao.insert(user);
        System.out.println(row==1?"新增用户成功":"新增用户失败");
    }

    /**
     * 测试根据id或name删除用户
     */
    @Test
    public void testDelete(){
        User userCondition = new User();
        userCondition.setId(7);

        int row = userDao.delete(userCondition);
        System.out.println(row==1?"通过id删除用户成功":"通过id删除用户失败");

        userCondition = new User();
        userCondition.setName("tom");
        row = userDao.delete(userCondition);
        System.out.println(row==1?"通过name删除用户成功":"通过name删除用户失败");
    }

    /**
     * 测试根据id修改name
     * 测试根据name修改password
     */
    @Test
    public void testUpdate(){
        User userCondition = new User();
        userCondition.setId(2);
        userCondition.setName("lisa");
        int row = userDao.update(userCondition);
        System.out.println(row==1?"根据用户id修改name成功":"根据用户id修改name失败");

        userCondition = new User();
        userCondition.setName("lisa");
        userCondition.setPassword("111111");
        row = userDao.update(userCondition);
        System.out.println(row==1?"根据用户name修改password成功":"根据用户name修改password失败");
    }

    /**
     * 测试查询全部用户
     * 测试根据id查询用户
     * 测试根据name与password查询用户
     */
    @Test
    public void testSelect(){
        User userCondition = null;
        List<User> userList = userDao.select(userCondition);
        if (userList.size()>0) {
            System.out.println("全部用户为：\n" + userList);
        }else {
            System.out.println("没有用户");
        }

        userCondition = new User();
        userCondition.setId(3);
        List<User> selectIdUser = userDao.select(userCondition);
        if (selectIdUser.size()>0) {
            System.out.println("根据id查询用户：\n" + selectIdUser);
        }else {
            System.out.println("根据id查询用户：\n未查到该用户");
        }

        userCondition = new User();
        userCondition.setName("lisa");
        userCondition.setPassword("666666");
        List<User> selectNamePasswordUser = userDao.select(userCondition);
        if (selectNamePasswordUser.size()>0) {
            System.out.println("根据name与password查询用户：\n" + selectNamePasswordUser);
        }else {
            System.out.println("根据name与password查询用户：\n未查到该用户");
        }
    }


    @Test
    public void testQuery(){
        CustomQueryRunner customQueryRunner = new CustomQueryRunner(DruidDataSourceUtil.getDataSource());
        String sql = "select * from jdbc_user where name = ? and password = ?";
        User user = new User();
        user.setName("admin");
        user.setPassword("111111");
        User queryUser = customQueryRunner.queryForObject(sql, User.class, user.getName(), user.getPassword());
        System.out.println(queryUser);
    }

    @Test
    public void testQueryForList(){
        CustomQueryRunner customQueryRunner = new CustomQueryRunner(DruidDataSourceUtil.getDataSource());
        String sql = "select * from jdbc_user";
        List<User> users = customQueryRunner.queryForList(sql, User.class);
        for (User user : users) {
            System.out.println(user);
        }
    }

}













