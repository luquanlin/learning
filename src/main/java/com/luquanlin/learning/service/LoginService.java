package com.luquanlin.learning.service;

import com.luquanlin.learning.entity.User;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/21 16:22
 * @VERSION: 1.0
 **/
public interface LoginService {
    List<User> selectUserLogin(String user_account,String user_password);
    List<User> selectAllUser();
}
