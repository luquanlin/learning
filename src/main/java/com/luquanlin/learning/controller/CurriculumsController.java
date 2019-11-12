package com.luquanlin.learning.controller;

import com.luquanlin.learning.entity.Curriculums;
import com.luquanlin.learning.service.CurriculumsService;
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

@Api(description = "课程接口")
@Controller
@RequestMapping("/Curriculums")
public class CurriculumsController {
    @Autowired
    private CurriculumsService curriculumsService;

    @RequestMapping("/selectAllCurriculums")
    @ResponseBody
    @ApiOperation(value = "查询所有课程",notes = "直接返回数据",httpMethod = "POST")
    public Map selectAllCurriculums(){
        Map result = new HashMap();
        List<Curriculums> curriculums = curriculumsService.selectAllCurriculums();
        result.put("data",curriculums);
        return result;
    }

    @RequestMapping("/insertCurriculumsInformation")
    @ResponseBody
    @ApiOperation(value = "插入课程",notes = "1:成功,0:失败",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name = "categorys_id" ,value = "类别id",required = true,dataType = "int"),
            @ApiImplicitParam(paramType="query",name = "curriculums_name" ,value = "课程名称",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "curriculums_content" ,value = "课程描述",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "curriculums_user" ,value = "课程讲师",required = true,dataType = "string")
    })
    public Map insertCurriculumsInformation(int categorys_id,String curriculums_name,String curriculums_content,String curriculums_user){
        Map result = new HashMap();
        if (curriculumsService.insertCurriculumsInformation(categorys_id, curriculums_name, curriculums_content, curriculums_user)) {
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }

    @RequestMapping("/updateCurriculumsInformation")
    @ResponseBody
    @ApiOperation(value = "修改课程",notes = "1:成功,0:失败",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name = "categorys_id" ,value = "类别id",required = true,dataType = "int"),
            @ApiImplicitParam(paramType="query",name = "curriculums_name" ,value = "课程名称",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "curriculums_content" ,value = "课程描述",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "curriculums_user" ,value = "课程讲师",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "curriculums_id" ,value = "课程id",required = true,dataType = "int")
    })
    public Map updateCurriculumsInformation(int categorys_id,String curriculums_name,String curriculums_content,String curriculums_user,int curriculums_id){
        Map result = new HashMap();
        if (curriculumsService.updateCurriculumsInformation(categorys_id, curriculums_name, curriculums_content, curriculums_user,curriculums_id)) {
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }

    @RequestMapping("/updateCurriculumsState")
    @ResponseBody
    @ApiOperation(value = "删除课程",notes = "1:成功,0:失败",httpMethod = "POST")
    @ApiImplicitParam(paramType="query",name = "curriculums_id" ,value = "课程id",required = true,dataType = "int")
    public Map updateCurriculumsState(int curriculums_id){
        Map result = new HashMap();
        if (curriculumsService.updateCurriculumsState(curriculums_id)) {
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }

    @RequestMapping("/selectCurriculumsFive")
    @ResponseBody
    @ApiOperation(value = "查询热度前五课程",notes = "直接返回数据",httpMethod = "POST")
    public Map selectCurriculumsFive(){
        Map result = new HashMap();
        List<Curriculums> curriculums = curriculumsService.selectCurriculumsFive();
        result.put("data",curriculums);
        return result;
    }

    @RequestMapping("/selectCategorysIdCurriculums")
    @ResponseBody
    @ApiOperation(value = "查询当前类别的课程",notes = "直接返回数据",httpMethod = "POST")
    public Map selectCategorysIdCurriculums(int categorys_id){
        Map result = new HashMap();
        List<Curriculums> curriculums = curriculumsService.selectCategorysIdCurriculums(categorys_id);
        result.put("data",curriculums);
        return result;
    }

}
