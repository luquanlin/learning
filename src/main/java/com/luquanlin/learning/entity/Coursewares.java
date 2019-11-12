package com.luquanlin.learning.entity;

/**
 * @Author: luquanlin
 * @Date: 2019/10/24 17:15
 * @VERSION: 1.0
 **/

public class Coursewares {
    private int coursewares_id;
    private String coursewares_name;
    private String coursewares_url;
    private int coursewares_sort;
    private String coursewares_state;
    private int curriculums_id;

    public int getCurriculums_id() {
        return curriculums_id;
    }

    public void setCurriculums_id(int curriculums_id) {
        this.curriculums_id = curriculums_id;
    }

    public String getCoursewares_state() {
        return coursewares_state;
    }

    public void setCoursewares_state(String coursewares_state) {
        this.coursewares_state = coursewares_state;
    }

    public int getCoursewares_id() {
        return coursewares_id;
    }

    public void setCoursewares_id(int coursewares_id) {
        this.coursewares_id = coursewares_id;
    }

    public String getCoursewares_name() {
        return coursewares_name;
    }

    public void setCoursewares_name(String coursewares_name) {
        this.coursewares_name = coursewares_name;
    }

    public String getCoursewares_url() {
        return coursewares_url;
    }

    public void setCoursewares_url(String coursewares_url) {
        this.coursewares_url = coursewares_url;
    }

    public int getCoursewares_sort() {
        return coursewares_sort;
    }

    public void setCoursewares_sort(int coursewares_sort) {
        this.coursewares_sort = coursewares_sort;
    }
}
