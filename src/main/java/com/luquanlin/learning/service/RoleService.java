package com.luquanlin.learning.service;

import com.luquanlin.learning.entity.Role;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/31 9:26
 * @VERSION: 1.0
 **/
public interface RoleService {
    List<Role> selectAllRole();
    boolean updateUserRoleState(int role_id);
    boolean updateRoleName(String role_name,int role_id);
    boolean insertRoleName(String role_name);
    List<Role> selectVagueRole(String role_name);
    List selectRolePowers(int role_id);
    boolean deleteRolePower(int role_id);
    boolean insertRolePower(int role_id,int power_id);
    List<Role> selectRoleMaxId();
}
