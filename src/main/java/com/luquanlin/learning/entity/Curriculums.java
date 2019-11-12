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
    private String curriculums_state;
    private int categorys_id;
    private String categorys_name;

    public String getCategorys_name() {
        return categorys_name;
    }

    public void setCategorys_name(String categorys_name) {
        this.categorys_name = categorys_name;
    }

    public int getCategorys_id() {
        return categorys_id;
    }

    public void setCategorys_id(int categorys_id) {
        this.categorys_id = categorys_id;
    }

    public String getCurriculums_state() {
        return curriculums_state;
    }

    public void setCurriculums_state(String curriculums_state) {
        this.curriculums_state = curriculums_state;
    }

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
