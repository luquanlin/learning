package com.luquanlin.learning.controller;

import com.luquanlin.learning.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
}
