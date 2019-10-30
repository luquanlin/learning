package com.luquanlin.learning.service;

import com.luquanlin.learning.entity.bean.PowerParent;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/30 17:27
 * @VERSION: 1.0
 **/
public interface PowerService {
    List<PowerParent> selectUserPower(int user_id);
}
