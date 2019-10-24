package com.luquanlin.learning.entity;

/**
 * @Author: luquanlin
 * @Date: 2019/10/24 17:04
 * @VERSION: 1.0
 **/

public class Role {
    private int role_id;
    private String role_name;
    private String role_state;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_state() {
        return role_state;
    }

    public void setRole_state(String role_state) {
        this.role_state = role_state;
    }
}
