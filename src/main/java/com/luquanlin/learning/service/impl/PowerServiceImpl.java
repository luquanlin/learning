package com.luquanlin.learning.service.impl;

import com.luquanlin.learning.entity.Power;
import com.luquanlin.learning.mapper.PowerMapper;
import com.luquanlin.learning.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: luquanlin
 * @Date: 2019/10/30 17:27
 * @VERSION: 1.0
 **/

@Service
public class PowerServiceImpl implements PowerService {
    @Autowired
    private PowerMapper powerMapper;

    //生成树
    public List<Map<String, Object>> buildTree(int power_id, List<Power> list){
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        // 1.边界条件
        List<Power> childList = list.stream().filter(item -> item.getPower_parentid()==power_id).collect(Collectors.toList());
        // 3.返回段
        if(childList.isEmpty()) return result;

        // 2.前进段
        childList.stream().forEach(item->{
            Map<String, Object> map = new HashMap<>();
            map.put("power_id", item.getPower_id());
            map.put("power_parentid", item.getPower_parentid());
            map.put("power_state", item.getPower_state());
            map.put("sort", item.getSort());
            map.put("power_name", item.getPower_name());
            map.put("power_url", item.getPower_url());
            map.put("describe", item.getDescribe());

            List<Map<String, Object>> childs = buildTree(item.getPower_id(), list);
            if(!childs.isEmpty()){
                map.put("listpower", childs);
            }

            result.add(map);
        });

        return result;
    }


    @Override
    public  List<Map<String, Object>> selectUserPower(int user_id) {
        List<Power> list = powerMapper.selectUserPower(user_id);
        return buildTree(0, list);
    }

    @Override
    public List<Map<String, Object>> selectAllPower() {
        List<Power> list = powerMapper.selectAllPower();
        return buildTree(0, list);
    }

    @Override
    public List<Power> selectAllPowers(){
        return powerMapper.selectAllPower();
    }

    @Override
    public boolean updateRoleInformation(String power_name, String power_parentid, String power_url, String describe, int power_id) {
        int result = powerMapper.updateRoleInformation(power_name, power_parentid, power_url, describe, power_id);
        if(result > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean insertPowerInformation(String power_name, String power_parentid, String power_url, String describe) {
        int result = powerMapper.insertPowerInformation(power_name, power_parentid, power_url, describe);
        if(result > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Power> selectMaxPowerId() {
        return powerMapper.selectMaxPowerId();
    }

    @Override
    public boolean updatePowerState(int power_id) {
        int result = powerMapper.updatePowerState(power_id);
        if(result > 0){
            return true;
        }
        return false;
    }
}
