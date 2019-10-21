package com.luquanlin.learning.mapper;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/21 16:21
 * @VERSION: 1.0
 **/
@Repository
public interface LoginMapper {
    List<HashMap> selectUserLogin(String user_account,String user_password);
}
