package com.luquanlin.learning.mapper;

import com.luquanlin.learning.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/21 16:21
 * @VERSION: 1.0
 **/
@Repository
public interface LoginMapper {
    List<User> selectUserLogin(String user_account,String user_password);
    List<User> selectAllUser();
    int insertUser(String user_name,String user_account,String user_password,String user_sex);
    List<User> selectUserAccount(String user_account);
}
