package com.hui.web.foundational.service.impl;

import com.hui.web.foundational.bean.entity.User;
import com.hui.web.foundational.dao.UserDao;
import com.hui.web.foundational.dao.impl.StatementUserDaoImpl;
import com.hui.web.foundational.service.UserService;

import java.util.List;

/**
 * 用户业务逻辑实现
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/31 17:55
 * @since JDK8
 */

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new StatementUserDaoImpl();

    @Override
    public boolean login(User user) {
        if (null!=user&&user.getName()!=null&&user.getPassword()!=null){
            List<User> userList = userDao.select(user);
            if (null!=userList&&userList.size()==1){
                return true;
            }
        }
        return false;
    }
}
