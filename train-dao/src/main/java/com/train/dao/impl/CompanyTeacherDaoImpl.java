package com.train.dao.impl;

import com.train.dao.declare.CompanyTeacherDao;
import com.train.dao.mapper.CompanyTeacherMapper;
import com.train.domain.entity.CompanyTeacher;
import com.train.domain.entity.CompanyTeacherExample;
import com.train.domain.entity.UserCompanyExample;
import com.train.utils.Constant;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/3 17:35
 * Description: ${DESCRIPTION}
 */
@Repository
public class CompanyTeacherDaoImpl implements CompanyTeacherDao {

    @Resource
    private CompanyTeacherMapper companyTeacherMapper;

    @Override
    public int insert(CompanyTeacher record) {
        Date date = new Date();
        record.setCreateBy(Constant.SYSTEM_NAME);
        record.setCreateTime(date);
        record.setUpdateBy(Constant.SYSTEM_NAME);
        record.setUpdateTime(date);
        return companyTeacherMapper.insert(record);
    }

    @Override
    public CompanyTeacher getById(Integer id) {
        return companyTeacherMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CompanyTeacher companyTeacher) {
        return companyTeacherMapper.updateByPrimaryKeySelective(companyTeacher);
    }

    @Override
    public List<CompanyTeacher> getCompanyTeacherList(Integer companyId, Integer start) {
        CompanyTeacherExample example = new CompanyTeacherExample();
        example.createCriteria().andIdGreaterThan(start).andCompanyIdEqualTo(companyId);
        example.setOrderByClause(" create_time desc limit "+10);
        return companyTeacherMapper.selectByExample(example);
    }
}
