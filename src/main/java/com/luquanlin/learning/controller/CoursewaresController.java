package com.luquanlin.learning.controller;

import com.luquanlin.learning.entity.Coursewares;
import com.luquanlin.learning.service.CoursewaresService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: luquanlin
 * @Date: 2019/10/20 17:50
 * @VERSION: 1.0
 **/

@Api(description = "课件接口")
@Controller
@RequestMapping("/Coursewares")
public class CoursewaresController {
    @Autowired
    private CoursewaresService coursewaresService;

    @RequestMapping("/selectCurriculumsIdCourseWares")
    @ResponseBody
    @ApiOperation(value = "查询当前课程的课件",notes = "直接返回数据",httpMethod = "POST")
    public Map selectCurriculumsIdCourseWares(int curriculums_id){
        Map result = new HashMap();
        List<Coursewares> coursewares = coursewaresService.selectCurriculumsIdCourseWares(curriculums_id);
        result.put("data",coursewares);
        return result;
    }

    @RequestMapping("/insertNewCourseWare")
    @ResponseBody
    @ApiOperation(value = "插入课件",notes = "1:成功,0:失败",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name = "curriculums_id" ,value = "课程id",required = true,dataType = "int"),
            @ApiImplicitParam(paramType="query",name = "coursewares_name" ,value = "课件名称",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "coursewares_url" ,value = "课件地址",required = true,dataType = "string")
    })
    public Map insertNewCourseWare(int curriculums_id,String coursewares_name,String coursewares_url){
        Map result = new HashMap();
        if (coursewaresService.insertNewCourseWare(curriculums_id, coursewares_name, coursewares_url)) {
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }

    @RequestMapping("/updateCourseWareInformation")
    @ResponseBody
    @ApiOperation(value = "修改课件",notes = "1:成功,0:失败",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name = "coursewares_id" ,value = "课件id",required = true,dataType = "int"),
            @ApiImplicitParam(paramType="query",name = "coursewares_name" ,value = "课件名称",required = true,dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "coursewares_url" ,value = "课件地址",required = true,dataType = "string")
    })
    public Map updateCourseWareInformation(int coursewares_id,String coursewares_name,String coursewares_url){
        Map result = new HashMap();
        if (coursewaresService.updateCourseWareInformation(coursewares_name, coursewares_url, coursewares_id)) {
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }

    @RequestMapping("/updateCourseWareState")
    @ResponseBody
    @ApiOperation(value = "删除课件",notes = "1:成功,0:失败",httpMethod = "POST")
    @ApiImplicitParam(paramType="query",name = "coursewares_id" ,value = "课件id",required = true,dataType = "int")
    public Map updateCourseWareState(int coursewares_id){
        Map result = new HashMap();
        if (coursewaresService.updateCourseWareState(coursewares_id)) {
            result.put("data",1);
        }else{
            result.put("data",0);
        }
        return result;
    }

    @RequestMapping("/insertVideoUrl")
    @ResponseBody
    @ApiOperation(value = "上传视频",notes = "1:成功,0:失败返回视频地址url",httpMethod = "POST")
    public Map insertVideoUrl(MultipartFile file, HttpServletRequest request){
        Map result = new HashMap();
        if(file.isEmpty()) {
            result.put("data", "文件为空");
            return result;
        }

        String realPath = "D:\\learning\\src\\main\\resources\\static\\video";
        File dir = new File(realPath);
        if (!dir.isDirectory()) {//文件目录不存在，就创建一个
            dir.mkdirs();
        }

        try {
            String filename = file.getOriginalFilename();
            //服务端保存的文件对象
            File fileServer = new File(dir, filename);
            System.out.println("file文件真实路径:" + fileServer.getAbsolutePath());
            //2，实现上传
            file.transferTo(fileServer);
            String filePath = request.getScheme() + "://" +
                    request.getServerName() + ":"
                    + request.getServerPort()
                    + "/video/" + filename;
            //3，返回可供访问的网络路径
            result.put("filePath",filePath);
            result.put("data",1);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping("/selectCurriculumIdCourses")
    @ResponseBody
    @ApiOperation(value = "查询课程的课件",notes = "返回所有数据",httpMethod = "POST")
    public Map selectCurriculumIdCourses(int curriculums_id){
        Map result = new HashMap();
        List<Coursewares> coursewares = coursewaresService.selectCurriculumIdCourses(curriculums_id);
        result.put("data",coursewares);
        return result;
    }


}
