package com.train.dao.declare;

import com.train.domain.entity.CompanyTeacher;

import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/3 17:35
 * Description: ${DESCRIPTION}
 */
public interface CompanyTeacherDao {

    int insert(CompanyTeacher record);


    CompanyTeacher getById(Integer id);

    int updateByPrimaryKeySelective(CompanyTeacher companyTeacher);

    List<CompanyTeacher> getCompanyTeacherList(Integer id, Integer start);
}
