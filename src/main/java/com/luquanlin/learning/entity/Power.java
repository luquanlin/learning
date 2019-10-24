package com.luquanlin.learning.entity;

/**
 * @Author: luquanlin
 * @Date: 2019/10/24 17:06
 * @VERSION: 1.0
 **/

public class Power {
    private int power_id;
    private int power_parentid;
    private int power_state;
    private int sort;
    private String power_name;
    private String power_url;
    private String describe;

    public int getPower_id() {
        return power_id;
    }

    public void setPower_id(int power_id) {
        this.power_id = power_id;
    }

    public int getPower_parentid() {
        return power_parentid;
    }

    public void setPower_parentid(int power_parentid) {
        this.power_parentid = power_parentid;
    }

    public int getPower_state() {
        return power_state;
    }

    public void setPower_state(int power_state) {
        this.power_state = power_state;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getPower_name() {
        return power_name;
    }

    public void setPower_name(String power_name) {
        this.power_name = power_name;
    }

    public String getPower_url() {
        return power_url;
    }

    public void setPower_url(String power_url) {
        this.power_url = power_url;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
