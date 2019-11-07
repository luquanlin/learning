package com.luquanlin.learning.service;

import com.luquanlin.learning.entity.User;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/11/3 22:11
 * @VERSION: 1.0
 **/
public interface UserService {
    List<HashMap> selectUsersRole();
    boolean updateUserPassword(int user_id);
    boolean updataUserState(int user_id);
    List selectUserIdRole(int user_id);
    boolean deleteUserRoles(int user_id);
    boolean insertUserRoles(int user_id,int role_id);
    boolean updateUserInformation(String user_name,String user_account,String user_sex,int user_id);
    boolean insertUserInformation(String user_name,String user_account,String user_sex);
    List<User> selectUserMaxId();
    boolean insertUserRolesId(int user_id,int role_id);
}
