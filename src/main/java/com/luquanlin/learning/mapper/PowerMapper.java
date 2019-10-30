package com.luquanlin.learning.mapper;

import com.luquanlin.learning.entity.Power;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/30 17:26
 * @VERSION: 1.0
 **/
@Repository
public interface PowerMapper {
    List<Power> selectUserPower(int user_id);
}
