package com.luquanlin.learning.service;

import com.luquanlin.learning.entity.Categorys;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/21 16:22
 * @VERSION: 1.0
 **/
public interface KindService {
    List<Categorys> selectAllCategory();
    boolean updateCategorysState(int categorys_id);
    boolean updateCategorysInformation(String categorys_name,String categorys_content,int categorys_id);
    boolean insertCategory(String categorys_name,String categorys_content);
}
