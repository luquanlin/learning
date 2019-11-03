package com.luquanlin.learning.service.impl;

import com.luquanlin.learning.entity.Power;
import com.luquanlin.learning.entity.bean.PowerParent;
import com.luquanlin.learning.mapper.PowerMapper;
import com.luquanlin.learning.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<PowerParent> selectUserPower(int user_id) {
        List<Power> powerList = powerMapper.selectUserPower(user_id);
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
