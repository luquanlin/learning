package com.luquanlin.learning.service;

import java.util.List;
import java.util.Map;

/**
 * @Author: luquanlin
 * @Date: 2019/10/30 17:27
 * @VERSION: 1.0
 **/
public interface PowerService {
    List<Map<String,Object>>selectUserPower(int user_id);
}
