package com.luquanlin.learning.service.impl;

import com.luquanlin.learning.mapper.LoginMapper;
import com.luquanlin.learning.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    @Override
    public List<HashMap> selectUserLogin(String user_account,String user_password) {
        return loginMapper.selectUserLogin(user_account,user_password);
    }
}
