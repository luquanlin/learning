package com.luquanlin.learning.controller;

import com.luquanlin.learning.entity.Role;
import com.luquanlin.learning.service.RoleService;
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
 * @Date: 2019/10/31 9:27
 * @VERSION: 1.0
 **/

@Controller
@RequestMapping("/Role")
@Api(description = "角色接口")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/selectAllRole")
    @ResponseBody
    @ApiOperation(value = "查询所有角色",notes = "直接返回数据",httpMethod = "POST")
    public Map selectAllRole(){
        Map result = new HashMap();
        List<Role> roles = roleService.selectAllRole();
        result.put("data",roles);
        return result;
    }

    @RequestMapping("/updateUserRoleState")
    @ResponseBody
    @ApiOperation(value = "删除角色",notes = "1:成功，0：失败",httpMethod = "POST")
    @ApiImplicitParam(paramType="query",name = "role_id" ,value = "角色id",required = true,dataType = "string")
    public Map updateUserRoleState(int role_id){
        Map result = new HashMap();
//        int role_ID = Integer.parseInt(role_id);
        if(roleService.updateUserRoleState(role_id)){
            result.put("data",1);
        }else {
            result.put("data",0);
        }
        return result;
    }

    @RequestMapping("/updateRoleName")
    @ResponseBody
    @ApiOperation(value = "修改角色名称",notes = "1:成功，0：失败",httpMethod = "POST")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query",name = "role_name" ,value = "角色名称",required = true,dataType = "string"),
        @ApiImplicitParam(paramType="query",name = "role_id" ,value = "角色id",required = true,dataType = "int"),
        @ApiImplicitParam(paramType="query",name = "powers" ,value = "权限id数组",required = true,dataType = "string"),
    })
    public Map updateRoleName(String role_name,int role_id,String powers){

        String powers_id[] = powers.split(",");

        Map result = new HashMap();
        if(roleService.updateRoleName(role_name,role_id)){
            roleService.deleteRolePower(role_id);
            if(powers.length() > 0){
                for(int j = 0;j < powers_id.length;j++){
                    if (Integer.parseInt(powers_id[j]) != 0){
                        if(roleService.insertRolePower(role_id,Integer.parseInt(powers_id[j]))){
                            result.put("data",1);
                        }else{
                            result.put("data",0);
                        }
                    }
                }
            }else{
                result.put("data",1);
            }

        }else{
            result.put("data",0);
        }
        return result;
    }

    @RequestMapping("/insertRoleName")
    @ResponseBody
    @ApiOperation(value = "插入角色名称",notes = "1:成功，0：失败",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name = "role_name" ,value = "角色名称",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "powers" ,value = "权限id数组",required = true,dataType = "string"),
    })
    public Map insertRoleName(String role_name,String powers){
        Map result = new HashMap();

        String powers_id[] = powers.split(",");
        if(roleService.insertRoleName(role_name)){
            List <Role> roles = roleService.selectRoleMaxId();
            int role_MaxId = roles.get(0).getRole_id();
            if(powers.length() > 0){
                for(int i = 0;i < powers_id.length;i++){
                    if (Integer.parseInt(powers_id[i]) != 0){
                        if(roleService.insertRolePower(role_MaxId,Integer.parseInt(powers_id[i]))){
                            result.put("data",1);
                        }else{
                            result.put("data",0);
                        }
                    }
                }
            }else{
                result.put("data",1);
            }

        }else {
            result.put("data",0);
        }

        return result;
    }
    @RequestMapping("/selectVagueRole")
    @ResponseBody
    @ApiOperation(value = "角色模糊查询",notes = "直接返回数据",httpMethod = "POST")
    @ApiImplicitParam(paramType="query",name = "role_name" ,value = "角色名称",required = true,dataType = "string")
    public Map selectVagueRole(String role_name){
        Map result = new HashMap();
        List<Role> roles = roleService.selectVagueRole(role_name);
        result.put("data",roles);
        return result;
    }

    @RequestMapping("/selectRolePowers")
    @ResponseBody
    @ApiOperation(value = "角色拥有那些权限",notes = "直接返回数据",httpMethod = "POST")
    @ApiImplicitParam(paramType="query",name = "role_id" ,value = "角色id",required = true,dataType = "int")
    public Map selectRolePowers(int role_id){
        Map result = new HashMap();
        List roles = roleService.selectRolePowers(role_id);
        result.put("data",roles);
        return result;
    }
}
