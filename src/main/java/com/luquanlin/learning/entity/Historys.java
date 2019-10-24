package com.luquanlin.learning.entity;

/**
 * @Author: luquanlin
 * @Date: 2019/10/24 17:11
 * @VERSION: 1.0
 **/

public class Historys {
    private int historys_id;
    private int user_id;
    private int coursewares_id;
    private String historys_time;

    public int getHistorys_id() {
        return historys_id;
    }

    public void setHistorys_id(int historys_id) {
        this.historys_id = historys_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCoursewares_id() {
        return coursewares_id;
    }

    public void setCoursewares_id(int coursewares_id) {
        this.coursewares_id = coursewares_id;
    }

    public String getHistorys_time() {
        return historys_time;
    }

    public void setHistorys_time(String historys_time) {
        this.historys_time = historys_time;
    }
}
