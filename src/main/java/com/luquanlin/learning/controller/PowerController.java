package com.luquanlin.learning.controller;

import com.luquanlin.learning.entity.bean.PowerParent;
import com.luquanlin.learning.service.PowerService;
import io.swagger.annotations.Api;
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
    public Map selectUserPower(){
        Map result = new HashMap();
        int user_id = 1;
        List<PowerParent> powers = powerService.selectUserPower(user_id);
        result.put("data",powers);
        return result;
    }
}
