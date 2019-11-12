package com.luquanlin.learning.mapper;

import com.luquanlin.learning.entity.Categorys;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/21 16:21
 * @VERSION: 1.0
 **/
@Repository
public interface KindMapper {
    List<Categorys> selectAllCategory();
    int updateCategorysState(int categorys_id);
    int updateCategorysInformation(String categorys_name,String categorys_content,int categorys_id);
    int insertCategory(String categorys_name,String categorys_content);
}
