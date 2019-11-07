package com.luquanlin.learning.controller;

import com.luquanlin.learning.entity.User;
import com.luquanlin.learning.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: luquanlin
 * @Date: 2019/11/3 22:15
 * @VERSION: 1.0
 **/
@Controller
@RequestMapping("/User")
@Api(description = "用户接口")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/selectUsersRole")
    @ResponseBody
    @ApiOperation(value = "查询所有信息",notes = "直接返回数据",httpMethod = "POST")
    public Map selectUsersRole(){
        Map result = new HashMap();
        List<HashMap> users = userService.selectUsersRole();
        result.put("data",users);
        return result;
    }

    @RequestMapping("/updateUserPassword")
    @ResponseBody
    @ApiOperation(value = "初始化用户密码",notes = "1:成功，0:失败",httpMethod = "POST")
    @ApiImplicitParam(paramType="query",name = "user_id" ,value = "用户id",required = true,dataType = "int")
    public Map updateUserPassword(int user_id){
        Map result = new HashMap();
        if(userService.updateUserPassword(user_id)){
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }

    @RequestMapping("/updataUserState")
    @ResponseBody
    @ApiOperation(value = "删除用户",notes = "1:成功，0:失败",httpMethod = "POST")
    @ApiImplicitParam(paramType="query",name = "user_id" ,value = "用户id",required = true,dataType = "int")
    public Map updataUserState(int user_id){
        Map result = new HashMap();
        if(userService.updataUserState(user_id)){
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }

    @RequestMapping("/selectUserIdRole")
    @ResponseBody
    @ApiOperation(value = "查询用户的角色",notes = "直接返回数组",httpMethod = "POST")
    @ApiImplicitParam(paramType="query",name = "user_id" ,value = "用户id",required = true,dataType = "int")
    public Map selectUserIdRole(int user_id){
        Map result = new HashMap();
        List userRoles = userService.selectUserIdRole(user_id);
        result.put("data",userRoles);
        return result;
    }

    @RequestMapping("/updateUserInformation")
    @ResponseBody
    @ApiOperation(value = "修改用户信息",notes = "直接返回数组",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name = "role_name" ,value = "角色名称",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "user_account" ,value = "权限id数组",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "user_sex" ,value = "权限id数组",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "user_id" ,value = "权限id数组",required = true,dataType = "int"),
            @ApiImplicitParam(paramType="query",name = "roles" ,value = "权限id数组",required = true,dataType = "string"),
    })
    public Map updateUserInformation(String user_name,String user_account,String user_sex,int user_id,String roles){
        Map result = new HashMap();
        String role_id[] = roles.split(",");
        if(userService.updateUserInformation(user_name, user_account, user_sex, user_id)){
            if(userService.deleteUserRoles(user_id)){
                if (roles.length()>0){
                    for (int i=0;i<role_id.length;i++){
                        if(userService.insertUserRoles(user_id,Integer.parseInt(role_id[i]))){
                            result.put("data",1);
                        }else{
                            result.put("data",0);
                        }
                    }
                }else{
                    result.put("data",1);
                }
            }else{
                result.put("data",0);
            }
        }else{
            result.put("data",0);
        }
        return result;
    }

    @RequestMapping("/insertUserInformation")
    @ResponseBody
    @ApiOperation(value = "添加用户信息",notes = "1:成功,0:失败",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name = "user_name" ,value = "用户名称",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "user_account" ,value = "权限id数组",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "user_sex" ,value = "权限id数组",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "roles" ,value = "权限id数组",required = true,dataType = "string"),
    })
    public Map insertUserInformation(String user_name,String user_account,String user_sex,String roles){
        Map result = new HashMap();
        String role_id[] = roles.split(",");
        if(userService.insertUserInformation(user_name, user_account, user_sex)){
            result.put("data",1);
            List<User> user_id = userService.selectUserMaxId();
            for (int i=0;i<role_id.length;i++){
                if(userService.insertUserRolesId(user_id.get(0).getUser_id(),Integer.parseInt(role_id[i]))){
                    result.put("data",1);
                }else{
                    result.put("data",0);
                }
            }
        }else{
            result.put("data",0);
        }
        return result;
    }
}
