package com.luquanlin.learning.mapper;

import com.luquanlin.learning.entity.Coursewares;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/21 16:21
 * @VERSION: 1.0
 **/
@Repository
public interface CoursewaresMapper {
    List<Coursewares> selectCurriculumsIdCourseWares(int curriculums_id);
    int insertNewCourseWare(int curriculums_id,String coursewares_name,String coursewares_url);
    int updateCourseWareState(int coursewares_id);
    int updateCourseWareInformation(String coursewares_name,String coursewares_url,int coursewares_id);
    List<Coursewares> selectCurriculumIdCourses(int curriculums_id);
}
