package com.luquanlin.learning.entity;

/**
 * @Author: luquanlin
 * @Date: 2019/10/24 17:12
 * @VERSION: 1.0
 **/

public class Categorys {
    private int categorys_id;
    private String categorys_name;
    private String categorys_content;
    private String categorys_state;


    public String getCategorys_state() {
        return categorys_state;
    }

    public void setCategorys_state(String categorys_state) {
        this.categorys_state = categorys_state;
    }

    public int getCategorys_id() {
        return categorys_id;
    }

    public void setCategorys_id(int categorys_id) {
        this.categorys_id = categorys_id;
    }

    public String getCategorys_name() {
        return categorys_name;
    }

    public void setCategorys_name(String categorys_name) {
        this.categorys_name = categorys_name;
    }

    public String getCategorys_content() {
        return categorys_content;
    }

    public void setCategorys_content(String categorys_content) {
        this.categorys_content = categorys_content;
    }
}
