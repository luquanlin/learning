package com.luquanlin.learning.mapper;

import com.luquanlin.learning.entity.Curriculums;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/21 16:21
 * @VERSION: 1.0
 **/
@Repository
public interface CurriculumsMapper {
    List<Curriculums> selectAllCurriculums();
    int insertCurriculumsInformation(int categorys_id,String curriculums_name,String curriculums_content,String curriculums_user);
    int updateCurriculumsInformation(int categorys_id,String curriculums_name,String curriculums_content,String curriculums_user,int curriculums_id);
    int updateCurriculumsState(int curriculums_id);
    List<Curriculums> selectCurriculumsFive();
    List<Curriculums> selectCategorysIdCurriculums(int categorys_id);
}
