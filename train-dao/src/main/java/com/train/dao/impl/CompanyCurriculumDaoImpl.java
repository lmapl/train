package com.train.dao.impl;

import com.train.dao.declare.CompanyCurriculumDao;
import com.train.dao.mapper.CompanyCurriculumMapper;
import com.train.domain.entity.CompanyCurriculum;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/5 16:00
 * Description: ${DESCRIPTION}
 */
@Repository
public class CompanyCurriculumDaoImpl implements CompanyCurriculumDao {

    @Resource
    private CompanyCurriculumMapper companyCurriculumMapper;
    @Override
    public int insert(CompanyCurriculum companyCurriculum) {
        return companyCurriculumMapper.insert(companyCurriculum);
    }
}
