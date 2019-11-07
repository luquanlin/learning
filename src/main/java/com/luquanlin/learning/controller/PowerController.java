package com.luquanlin.learning.controller;

import com.luquanlin.learning.entity.User;
import com.luquanlin.learning.entity.bean.PowerParent;
import com.luquanlin.learning.service.PowerService;
import io.swagger.annotations.Api;
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
        List<PowerParent> powers = powerService.selectAllPower();
        result.put("data",powers);
        return result;
    }
}
