package com.luquanlin.learning.controller;

import com.luquanlin.learning.entity.Power;
import com.luquanlin.learning.entity.User;
import com.luquanlin.learning.service.PowerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: luquanlin
 * @Date: 2019/10/30 17:28
 * @VERSION: 1.0
 **/
@Api(description = "权限接口")
@Controller
@RequestMapping("/Power")
public class PowerController {
    @Autowired
    private PowerService powerService;

    @ResponseBody
    @RequestMapping("/selectUserPower")
    @ApiOperation(value="登录用户的所有权限", notes="直接返回数据",httpMethod = "POST")
    public Map selectUserPower(HttpServletRequest request){
        HttpSession session = request.getSession();
        List<User> user =(List<User>) session.getAttribute("user");
        Map result = new HashMap();
        int user_id = user.get(0).getUser_id();
        List<Map<String, Object>>  powers = powerService.selectUserPower(user_id);
        result.put("data",powers);
        return result;
    }

    @ResponseBody
    @RequestMapping("/selectAllPower")
    @ApiOperation(value="所有权限", notes="直接返回数据",httpMethod = "POST")
    public Map selectAllPower(){
        Map result = new HashMap();
        List<Map<String, Object>> powers = powerService.selectAllPower();
        result.put("data",powers);
        return result;
    }

    @ResponseBody
    @RequestMapping("/selectAllPowers")
    @ApiOperation(value="所有权限(非树形)", notes="直接返回数据",httpMethod = "POST")
    public Map selectAllPowers(){
        Map result = new HashMap();
        List<Power> powers = powerService.selectAllPowers();
        result.put("data",powers);
        return result;
    }

    @RequestMapping("/updateRoleInformation")
    @ResponseBody
    @ApiOperation(value = "修改权限信息",notes = "1:成功,0:失败",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name = "power_name" ,value = "权限名称",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "power_parentid" ,value = "权限父ID",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "power_url" ,value = "权限地址",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "describe" ,value = "权限描述",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "power_id" ,value = "权限id",required = true,dataType = "int"),

    })
    public Map updateRoleInformation(String power_name, String power_parentid, String power_url, String describe, int power_id){
        Map result = new HashMap();
        if(powerService.updateRoleInformation(power_name, power_parentid, power_url, describe, power_id)){
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }

    @RequestMapping("/insertPowerInformation")
    @ResponseBody
    @ApiOperation(value = "插入权限信息",notes = "1:成功,0:失败",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name = "power_name" ,value = "权限名称",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "power_parentid" ,value = "权限父ID",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "power_url" ,value = "权限地址",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "describe" ,value = "权限描述",required = true,dataType = "string"),
    })
    public Map insertPowerInformation(String power_name,String power_parentid,String power_url,String describe){
        Map result = new HashMap();
        if(powerService.insertPowerInformation(power_name, power_parentid, power_url, describe)){
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }

    @RequestMapping("/updatePowerState")
    @ResponseBody
    @ApiOperation(value = "删除权限",notes = "1:成功,0:失败",httpMethod = "POST")
    @ApiImplicitParam(paramType="query",name = "power_id" ,value = "权限名称",required = true,dataType = "int")
    public Map updatePowerState(int power_id){
        Map result = new HashMap();
        if(powerService.updatePowerState(power_id)){
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }
}
