package com.hui.web.foundational.service;

import com.hui.web.foundational.bean.entity.User;
import com.hui.web.foundational.service.impl.UserServiceImpl;
import org.testng.annotations.Test;

/**
 * 用户业务逻辑测试用例
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/31 17:56
 * @since JDK8
 */

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void testLogin(){
        String name = null;
        String password = null;

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        boolean loginResult = userService.login(user);
        System.out.println(loginResult==true?"登录成功":"登陆失败");

        name = "admin";
        password = "111111";
        user = new User();
        user.setName(name);
        user.setPassword(password);
        loginResult = userService.login(user);
        System.out.println(loginResult==true?"登录成功":"登陆失败");
    }
}
