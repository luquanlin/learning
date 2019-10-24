package com.luquanlin.learning.entity;

/**
 * @Author: luquanlin
 * @Date: 2019/10/24 17:09
 * @VERSION: 1.0
 **/

public class Comments {
    private int comments_id;
    private int user_id;
    private int curriculums_id;
    private String comments_content;
    private String comments_time;

    public int getComments_id() {
        return comments_id;
    }

    public void setComments_id(int comments_id) {
        this.comments_id = comments_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCurriculums_id() {
        return curriculums_id;
    }

    public void setCurriculums_id(int curriculums_id) {
        this.curriculums_id = curriculums_id;
    }

    public String getComments_content() {
        return comments_content;
    }

    public void setComments_content(String comments_content) {
        this.comments_content = comments_content;
    }

    public String getComments_time() {
        return comments_time;
    }

    public void setComments_time(String comments_time) {
        this.comments_time = comments_time;
    }
}
