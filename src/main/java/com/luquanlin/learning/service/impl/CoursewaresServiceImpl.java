package com.luquanlin.learning.service.impl;

import com.luquanlin.learning.entity.Coursewares;
import com.luquanlin.learning.mapper.CoursewaresMapper;
import com.luquanlin.learning.service.CoursewaresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/21 16:23
 * @VERSION: 1.0
 **/
@Service
public class CoursewaresServiceImpl implements CoursewaresService {
    @Autowired
    private CoursewaresMapper coursewaresMapper;

    @Override
    public List<Coursewares> selectCurriculumsIdCourseWares(int curriculums_id) {
        return coursewaresMapper.selectCurriculumsIdCourseWares(curriculums_id);
    }

    @Override
    public boolean insertNewCourseWare(int curriculums_id, String coursewares_name, String coursewares_url) {
        int userResult = coursewaresMapper.insertNewCourseWare(curriculums_id, coursewares_name, coursewares_url);
        if (userResult > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCourseWareState(int coursewares_id) {
        int userResult = coursewaresMapper.updateCourseWareState(coursewares_id);
        if (userResult > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCourseWareInformation(String coursewares_name, String coursewares_url, int coursewares_id) {
        int userResult = coursewaresMapper.updateCourseWareInformation(coursewares_name, coursewares_url, coursewares_id);
        if (userResult > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Coursewares> selectCurriculumIdCourses(int curriculums_id) {
        return coursewaresMapper.selectCurriculumIdCourses(curriculums_id);
    }
}
