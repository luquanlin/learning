package com.luquanlin.learning.service.impl;

import com.luquanlin.learning.entity.User;
import com.luquanlin.learning.mapper.LoginMapper;
import com.luquanlin.learning.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/21 16:23
 * @VERSION: 1.0
 **/
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public List<User> selectUserLogin(String user_account, String user_password) {
        return loginMapper.selectUserLogin(user_account,user_password);
    }

    @Override
    @Cacheable(value = "users",key = "#root.methodName",unless="#result == null")
    public List<User> selectAllUser() {
        return loginMapper.selectAllUser();
    }

    @Override
    public boolean insertUser(String user_name, String user_account, String user_password, String user_sex) {
       int userResult = loginMapper.insertUser(user_name, user_account, user_password, user_sex);
       if (userResult > 0){
           return true;
       }
        return false;
    }

    @Override
    public List<User> selectUserAccount(String user_account) {
        return loginMapper.selectUserAccount(user_account);
    }
}
