package com.luquanlin.learning.entity;

import java.io.Serializable;

/**
 * @Author: luquanlin
 * @Date: 2019/10/24 17:02
 * @VERSION: 1.0
 **/

public class UserRole implements Serializable {
    private int userrole_id;
    private int user_id;
    private int role_id;

    public int getUserrole_id() {
        return userrole_id;
    }

    public void setUserrole_id(int userrole_id) {
        this.userrole_id = userrole_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
