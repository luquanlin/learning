package com.luquanlin.learning.mapper;

import com.luquanlin.learning.entity.User;
import com.luquanlin.learning.entity.UserRole;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/11/3 22:10
 * @VERSION: 1.0
 **/
@Repository
public interface UserMapper {
    List<HashMap> selectUsersRole();
    int updateUserPassword(int user_id);
    int updataUserState(int user_id);
    List<UserRole> selectUserIdRole(int user_id);
    int deleteUserRoles(int user_id);
    int insertUserRoles(int user_id,int role_id);
    int updateUserInformation(String user_name,String user_account,String user_sex,int user_id);
    int insertUserInformation(String user_name,String user_account,String user_sex);
    List<User> selectUserMaxId();
    int insertUserRolesId(int user_id,int role_id);

}
