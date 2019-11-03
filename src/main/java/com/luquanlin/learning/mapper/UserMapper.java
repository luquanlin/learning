package com.luquanlin.learning.mapper;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/11/3 22:10
 * @VERSION: 1.0
 **/
@Repository
public interface UserMapper {
    List<HashMap> selectUsersRole();
    int updateUserPassword(int user_id);
}
