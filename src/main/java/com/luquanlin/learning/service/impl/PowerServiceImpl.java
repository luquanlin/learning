package com.luquanlin.learning.service.impl;

import com.luquanlin.learning.mapper.PowerMapper;
import com.luquanlin.learning.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: luquanlin
 * @Date: 2019/10/30 17:27
 * @VERSION: 1.0
 **/

@Service
public class PowerServiceImpl implements PowerService {
    @Autowired
    private PowerMapper powerMapper;

    @Override
    public List<Map<String, Object>> selectUserPower(int user_id) {
        return null;
    }
}
