package com.luquanlin.learning.service.impl;

import com.luquanlin.learning.entity.Role;
import com.luquanlin.learning.entity.RolePower;
import com.luquanlin.learning.mapper.RoleMapper;
import com.luquanlin.learning.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/31 9:26
 * @VERSION: 1.0
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectAllRole() {
        return roleMapper.selectAllRole();
    }

    @Override
    public boolean updateUserRoleState(int role_id) {
        int result = roleMapper.updateUserRoleState(role_id);
        if(result>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRoleName(String role_name, int role_id) {
        int result = roleMapper.updateRoleName(role_name,role_id);
        if(result>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean insertRoleName(String role_name) {
        int result = roleMapper.insertRoleName(role_name);
        if(result>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Role> selectVagueRole(String role_name) {
        return roleMapper.selectVagueRole(role_name);
    }

    @Override
    public List selectRolePowers(int role_id) {
        List<RolePower> rolePowers = roleMapper.selectRolePowers(role_id);
        List power_id = new ArrayList();
        for(int i=0;i<rolePowers.size();i++){
            power_id.add(rolePowers.get(i).getPower_id());
        }
        return power_id;
    }

    @Override
    public boolean deleteRolePower(int role_id) {
        int result = roleMapper.deleteRolePower(role_id);
        if(result>0){
            return true;
        }
        return false;

    }

    @Override
    public boolean insertRolePower(int role_id, int power_id) {
        int result = roleMapper.insertRolePower(role_id,power_id);
        if(result>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Role> selectRoleMaxId() {
        return roleMapper.selectRoleMaxId();
    }
}
