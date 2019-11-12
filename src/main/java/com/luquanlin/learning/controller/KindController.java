package com.luquanlin.learning.controller;

import com.luquanlin.learning.entity.Categorys;
import com.luquanlin.learning.service.KindService;
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
 * @Date: 2019/10/20 17:50
 * @VERSION: 1.0
 **/

@Api(description = "课程类别接口")
@Controller
@RequestMapping("/Kind")
public class KindController {
    @Autowired
    private KindService kindService;

    @ApiOperation(value="查询课程类别全部信息", notes="直接返回数据",httpMethod = "POST")
    @ResponseBody
    @RequestMapping("/selectAllCategory")
    public Map selectAllCategory(){
        Map result = new HashMap();
        List<Categorys> categorys = kindService.selectAllCategory();
        result.put("data",categorys);
        return result;
    }

    @RequestMapping("/updateCategorysState")
    @ResponseBody
    @ApiOperation(value = "删除类别",notes = "1:成功,0:失败",httpMethod = "POST")
    @ApiImplicitParam(paramType="query",name = "categorys_id" ,value = "类别id",required = true,dataType = "int")
    public Map updateCategorysState(int categorys_id){
        Map result = new HashMap();
        if (kindService.updateCategorysState(categorys_id)) {
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }

    @RequestMapping("/updateCategorysInformation")
    @ResponseBody
    @ApiOperation(value = "修改类别",notes = "1:成功,0:失败",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name = "categorys_name" ,value = "类别名称",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "categorys_content" ,value = "类别描述",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "categorys_id" ,value = "类别id",required = true,dataType = "int")
    })
    public Map updateCategorysInformation(String categorys_name,String categorys_content,int categorys_id){
        Map result = new HashMap();
        if (kindService.updateCategorysInformation(categorys_name, categorys_content, categorys_id)) {
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }

    @RequestMapping("/insertCategory")
    @ResponseBody
    @ApiOperation(value = "插入类别",notes = "1:成功,0:失败",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name = "categorys_name" ,value = "类别名称",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "categorys_content" ,value = "类别描述",required = true,dataType = "string")
    })
    public Map insertCategory(String categorys_name,String categorys_content){
        Map result = new HashMap();
        if (kindService.insertCategory(categorys_name, categorys_content)) {
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }

}
