package com.luquanlin.learning.service;

import com.luquanlin.learning.entity.Power;

import java.util.List;
import java.util.Map;

/**
 * @Author: luquanlin
 * @Date: 2019/10/30 17:27
 * @VERSION: 1.0
 **/
public interface PowerService {
    List<Map<String, Object>> selectUserPower(int user_id);
    List<Map<String, Object>> selectAllPower();
    List<Power> selectAllPowers();
    boolean updateRoleInformation(String power_name,String power_parentid,String power_url,String describe,int power_id);
    boolean insertPowerInformation(String power_name,String power_parentid,String power_url,String describe);
    List<Power> selectMaxPowerId();
    boolean updatePowerState(int power_id);
}
