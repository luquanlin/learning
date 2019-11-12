package com.luquanlin.learning.service.impl;

import com.luquanlin.learning.entity.Categorys;
import com.luquanlin.learning.mapper.KindMapper;
import com.luquanlin.learning.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/21 16:23
 * @VERSION: 1.0
 **/
@Service
public class KindServiceImpl implements KindService {
    @Autowired
    private KindMapper kindMapper;

    @Override
    public List<Categorys> selectAllCategory() {
        return kindMapper.selectAllCategory();
    }

    @Override
    public boolean updateCategorysState( int categorys_id) {
        int userResult = kindMapper.updateCategorysState( categorys_id);
        if (userResult > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCategorysInformation(String categorys_name, String categorys_content, int categorys_id) {
        int userResult = kindMapper.updateCategorysInformation(categorys_name, categorys_content, categorys_id);
        if (userResult > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean insertCategory(String categorys_name, String categorys_content) {
        int userResult = kindMapper.insertCategory(categorys_name, categorys_content);
        if (userResult > 0){
            return true;
        }
        return false;
    }
}
