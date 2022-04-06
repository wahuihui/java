package com.hui.web.foundational.service;

import com.hui.web.foundational.bean.entity.User;

/**
 * 用户业务逻辑
 *
 * @author hui 1154437939@qq.com
 * @version 2022/3/31 17:54
 * @since JDK8
 */

public interface UserService {

    /**
     * 根据用户名密码登录
     * @param user 用户条件
     * @return 是否成功
     */
    boolean login(User user);
}
