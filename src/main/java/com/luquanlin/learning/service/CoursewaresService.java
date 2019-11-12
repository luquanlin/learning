package com.luquanlin.learning.service;

import com.luquanlin.learning.entity.Coursewares;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/21 16:22
 * @VERSION: 1.0
 **/
public interface CoursewaresService {
    List<Coursewares> selectCurriculumsIdCourseWares(int curriculums_id);
    boolean insertNewCourseWare(int curriculums_id,String coursewares_name,String coursewares_url);
    boolean updateCourseWareState(int coursewares_id);
    boolean updateCourseWareInformation(String coursewares_name,String coursewares_url,int coursewares_id);
    List<Coursewares> selectCurriculumIdCourses(int curriculums_id);

}
