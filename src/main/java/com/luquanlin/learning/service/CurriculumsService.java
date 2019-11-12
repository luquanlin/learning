package com.luquanlin.learning.service;

import com.luquanlin.learning.entity.Curriculums;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/21 16:22
 * @VERSION: 1.0
 **/
public interface CurriculumsService {
    List<Curriculums> selectAllCurriculums();
    boolean insertCurriculumsInformation(int categorys_id,String curriculums_name,String curriculums_content,String curriculums_user);
    boolean updateCurriculumsInformation(int categorys_id,String curriculums_name,String curriculums_content,String curriculums_user,int curriculums_id);
    boolean updateCurriculumsState(int curriculums_id);
    List<Curriculums> selectCurriculumsFive();
    List<Curriculums> selectCategorysIdCurriculums(int categorys_id);
}
