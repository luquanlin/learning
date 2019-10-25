package com.luquanlin.learning;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: luquanlin
 * @Date: 2019/10/24 8:59
 * @VERSION: 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test_1{
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void set(){
//        redisTemplate.opsForValue().set("myKey","myValueObject0.0");
        System.out.println(redisTemplate.opsForValue().get("users::selectAllUser"));
    }
}
