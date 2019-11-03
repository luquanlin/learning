package com.luquanlin.learning.service.impl;

import com.luquanlin.learning.mapper.UserMapper;
import com.luquanlin.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
