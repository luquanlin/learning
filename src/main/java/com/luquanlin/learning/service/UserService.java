package com.luquanlin.learning.service;

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
}
