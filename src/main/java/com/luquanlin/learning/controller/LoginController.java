package com.luquanlin.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: luquanlin
 * @Date: 2019/10/20 17:50
 * @VERSION: 1.0
 **/

@Controller
@RequestMapping("/Login")
public class LoginController {

    @RequestMapping("/GoIndex")
    public String GoIndex(){
        return "index";
    }

    @RequestMapping("/GoLogin")
    public String GoLogin(){
        return "login/login";
    }
}
