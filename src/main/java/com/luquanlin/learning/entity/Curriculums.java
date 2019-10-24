package com.luquanlin.learning.entity;

/**
 * @Author: luquanlin
 * @Date: 2019/10/24 17:13
 * @VERSION: 1.0
 **/

public class Curriculums {
    private int curriculums_id;
    private String curriculums_name;
    private String curriculums_content;
    private String curriculums_user;
    private String curriculums_hot;

    public int getCurriculums_id() {
        return curriculums_id;
    }

    public void setCurriculums_id(int curriculums_id) {
        this.curriculums_id = curriculums_id;
    }

    public String getCurriculums_name() {
        return curriculums_name;
    }

    public void setCurriculums_name(String curriculums_name) {
        this.curriculums_name = curriculums_name;
    }

    public String getCurriculums_content() {
        return curriculums_content;
    }

    public void setCurriculums_content(String curriculums_content) {
        this.curriculums_content = curriculums_content;
    }

    public String getCurriculums_user() {
        return curriculums_user;
    }

    public void setCurriculums_user(String curriculums_user) {
        this.curriculums_user = curriculums_user;
    }

    public String getCurriculums_hot() {
        return curriculums_hot;
    }

    public void setCurriculums_hot(String curriculums_hot) {
        this.curriculums_hot = curriculums_hot;
    }
}
