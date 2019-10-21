package com.luquanlin.learning.controller;

import com.luquanlin.learning.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: luquanlin
 * @Date: 2019/10/20 17:50
 * @VERSION: 1.0
 **/

@Api(description = "登录用户接口")
@Controller
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @ApiOperation(value="登陆时查询用户是否存在", notes="data:1登陆成功，0登陆失败",httpMethod = "POST")
    @ApiImplicitParams ({
        @ApiImplicitParam(paramType="query",name = "user_account" ,value = "用户账号",required = true,dataType = "string"),
        @ApiImplicitParam(paramType="query",name = "user_password" ,value = "用户密码",required = true,dataType = "string")
    })
    @ResponseBody
    @RequestMapping("/selectUserLogin")
    public Map selectUserLogin(@RequestParam("user_account") String user_account, @RequestParam("user_password") String user_password){
        Map result = new HashMap();
        List<HashMap> user = loginService.selectUserLogin(user_account,user_password);
        if(user.size()>0){
            result.put("data",1);
        }else {
            result.put("data",0);
        }
        return result;
    }

    @ApiIgnore
    @RequestMapping("/GoIndex")
    public String GoIndex(){
        return "index";
    }

    @ApiIgnore
    @RequestMapping("/GoLogin")
    public String GoLogin(){
        return "login/login";
    }
}
