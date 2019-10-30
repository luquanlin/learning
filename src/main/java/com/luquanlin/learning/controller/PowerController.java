package com.luquanlin.learning.controller;

import com.luquanlin.learning.service.PowerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
