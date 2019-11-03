package com.luquanlin.learning.mapper;

import com.luquanlin.learning.entity.Role;
import com.luquanlin.learning.entity.RolePower;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/31 9:25
 * @VERSION: 1.0
 **/
@Repository
public interface RoleMapper {
    List<Role> selectAllRole();
    int updateUserRoleState(int role_id);
    int updateRoleName(String role_name,int role_id);
    int insertRoleName(String role_name);
    List<Role> selectVagueRole(String role_name);
    List<RolePower> selectRolePowers(int role_id);
    int deleteRolePower(int role_id);
    int insertRolePower(int role_id,int power_id);
    List<Role> selectRoleMaxId();
}
