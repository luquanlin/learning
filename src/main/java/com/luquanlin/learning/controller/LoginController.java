package com.luquanlin.learning.controller;

import com.luquanlin.learning.entity.User;
import com.luquanlin.learning.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @ApiOperation(value="登陆时查询用户是否存在", notes="data:1管理员,2普通用户，0登陆失败",httpMethod = "POST")
    @ApiImplicitParams ({
        @ApiImplicitParam(paramType="query",name = "user_account" ,value = "用户账号",required = true,dataType = "string"),
        @ApiImplicitParam(paramType="query",name = "user_password" ,value = "用户密码",required = true,dataType = "string")
    })
    @ResponseBody
    @RequestMapping("/selectUserLogin")
    public Map selectUserLogin(String user_account,String user_password,HttpServletRequest request){
        Map result = new HashMap();
        List<User> user = loginService.selectUserLogin(user_account,user_password);
        HttpSession session = request.getSession();
        if(user.size()>0){
            session.setAttribute("user",user);
            for(int i=0;i<user.size();i++){
                if(user.get(i).getRole_name().equals("管理员")){
                    result.put("data",1);
                    return result;
                }else{
                    result.put("data",2);
                }
            }
        }else {
            result.put("data",0);
        }
        return result;
    }


    @ApiOperation(value="查询session的值", notes="直接返回数据",httpMethod = "POST")
    @ResponseBody
    @RequestMapping("/selectSession")
    public Map selectSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        List<User> user =(List<User>) session.getAttribute("user");
        Map result = new HashMap();
        result.put("data",user);
        return result;
    }

    @ApiOperation(value="查询所有用户", notes="直接返回数据",httpMethod = "POST")
    @ResponseBody
    @RequestMapping("/selectAllUser")
    public Map selectAllUser(){
        Map result = new HashMap();
        List<User> user = loginService.selectAllUser();
        result.put("data",user);
        return result;
    }

    @ApiOperation(value="用户注册", notes="1：成功，0：失败",httpMethod = "POST")
    @ApiImplicitParams ({
            @ApiImplicitParam(paramType="query",name = "user_name" ,value = "用户昵称",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "user_account" ,value = "用户账号",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "user_password" ,value = "用户密码",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "user_sex" ,value = "用户性别",required = true,dataType = "string")
    })
    @ResponseBody
    @RequestMapping("/insertUser")
    public Map insertUser(String user_name, String user_account, String user_password, String user_sex){
        Map result = new HashMap();
        if(loginService.insertUser(user_name, user_account, user_password, user_sex)){
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }

    @ApiOperation(value="查询手机号是否存在", notes="1：存在，0：不存在",httpMethod = "POST")
    @ApiImplicitParam(paramType="query",name = "user_account" ,value = "用户账号",required = true,dataType = "string")
    @ResponseBody
    @RequestMapping("/selectUserAccount")
    public Map selectUserAccount(String user_account){
        Map result = new HashMap();
        List<User> user = loginService.selectUserAccount(user_account);

        if(user.size()>0){
            result.put("data",1);
        }else {
            result.put("data",0);
        }
        return result;
    }



    @ApiIgnore
    @RequestMapping("/GoLogin")
    public String GoLogin(){
        return "login/login.html";
    }

}
