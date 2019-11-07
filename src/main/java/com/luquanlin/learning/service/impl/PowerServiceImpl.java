package com.luquanlin.learning.service.impl;

import com.luquanlin.learning.entity.Power;
import com.luquanlin.learning.entity.bean.PowerParent;
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
    public List<PowerParent> selectAllPower() {
        List<Power> powerList = powerMapper.selectAllPower();
        List<PowerParent> parentlist = new ArrayList<>();

        for(Power item : powerList){
            PowerParent powerParent = new PowerParent();
            if (item.getPower_parentid()==0){
                powerParent.setPower_id(item.getPower_id());
                powerParent.setDescribe(item.getDescribe());
                powerParent.setPower_name(item.getPower_name());
                parentlist.add(powerParent);
            }
        }

        for (PowerParent items:parentlist) {
            List<Power> listed = new ArrayList<>();
            for (Power item:powerList) {
                if (items.getPower_id()==item.getPower_parentid()){
                    listed.add(item);
                }
            }
            items.setListpower(listed);
        }
        return parentlist;
    }
}
