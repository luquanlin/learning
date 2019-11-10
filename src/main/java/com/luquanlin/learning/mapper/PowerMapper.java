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
    List<Power> selectAllPower();
    int updateRoleInformation(String power_name,String power_parentid,String power_url,String describe,int power_id);
    int insertPowerInformation(String power_name,String power_parentid,String power_url,String describe);
    List<Power> selectMaxPowerId();
    int updatePowerState(int power_id);
}
