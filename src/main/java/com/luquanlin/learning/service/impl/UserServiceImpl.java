package com.luquanlin.learning.service.impl;

import com.luquanlin.learning.entity.User;
import com.luquanlin.learning.entity.UserRole;
import com.luquanlin.learning.mapper.UserMapper;
import com.luquanlin.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/11/3 22:12
 * @VERSION: 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<HashMap> selectUsersRole() {
        return userMapper.selectUsersRole();
    }

    @Override
    public boolean updateUserPassword(int user_id) {
        int result = userMapper.updateUserPassword(user_id);
        if(result > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updataUserState(int user_id) {
        int result = userMapper.updataUserState(user_id);
        if(result > 0){
            return true;
        }
        return false;
    }

    @Override
    public List selectUserIdRole(int user_id) {
        List<UserRole> userRoles = userMapper.selectUserIdRole(user_id);
        List roles = new ArrayList();
        for(int i=0;i<userRoles.size();i++){
            roles.add(userRoles.get(i).getRole_id());
        }
        return roles;
    }

    @Override
    public boolean updateUserInformation(String user_name, String user_account, String user_sex, int user_id) {
        int result = userMapper.updateUserInformation(user_name, user_account, user_sex, user_id);
        if(result > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUserRoles(int user_id) {
        int result = userMapper.deleteUserRoles(user_id);
        if(result > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean insertUserRoles(int user_id, int role_id) {
        int result = userMapper.insertUserRoles(user_id,role_id);
        if(result > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean insertUserInformation(String user_name, String user_account, String user_sex) {
        int result = userMapper.insertUserInformation(user_name, user_account, user_sex);
        if(result > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<User> selectUserMaxId() {
        return userMapper.selectUserMaxId();
    }

    @Override
    public boolean insertUserRolesId(int user_id, int role_id) {
        int result = userMapper.insertUserRolesId(user_id, role_id);
        if(result > 0){
            return true;
        }
        return false;
    }
}
