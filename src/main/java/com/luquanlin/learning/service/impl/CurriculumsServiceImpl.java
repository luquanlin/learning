package com.luquanlin.learning.service.impl;

import com.luquanlin.learning.entity.Curriculums;
import com.luquanlin.learning.mapper.CurriculumsMapper;
import com.luquanlin.learning.service.CurriculumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: luquanlin
 * @Date: 2019/10/21 16:23
 * @VERSION: 1.0
 **/
@Service
public class CurriculumsServiceImpl implements CurriculumsService {
    @Autowired
    private CurriculumsMapper curriculumsMapper;

    @Override
    public List<Curriculums> selectAllCurriculums() {
        return curriculumsMapper.selectAllCurriculums();
    }

    @Override
    public boolean insertCurriculumsInformation(int categorys_id, String curriculums_name, String curriculums_content, String curriculums_user) {
        int userResult = curriculumsMapper.insertCurriculumsInformation(categorys_id, curriculums_name, curriculums_content, curriculums_user);
        if (userResult > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCurriculumsInformation(int categorys_id, String curriculums_name, String curriculums_content, String curriculums_user, int curriculums_id) {
        int userResult = curriculumsMapper.updateCurriculumsInformation(categorys_id, curriculums_name, curriculums_content, curriculums_user, curriculums_id);
        if (userResult > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCurriculumsState(int curriculums_id) {
        int userResult = curriculumsMapper.updateCurriculumsState(curriculums_id);
        if (userResult > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Curriculums> selectCurriculumsFive() {
        return curriculumsMapper.selectCurriculumsFive();
    }

    @Override
    public List<Curriculums> selectCategorysIdCurriculums(int categorys_id) {
        return curriculumsMapper.selectCategorysIdCurriculums(categorys_id);
    }
}
