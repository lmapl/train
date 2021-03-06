package com.train.service.common;

import com.train.domain.bean.CompanyCurriculumInfo;
import com.train.domain.bean.CompanyInfo;
import com.train.domain.bean.CompanyTeacherInfo;

import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/3 17:19
 * Description: ${DESCRIPTION}
 */
public interface CompanyService {
    Boolean addTeacher(String autograph, CompanyTeacherInfo teacherInfo);

    Boolean modifyTeacher(String autograph, CompanyTeacherInfo teacherInfo);

    Boolean addCurriculum(String autograph, CompanyCurriculumInfo info);

    //查询机构列表（客户端）
    List<CompanyInfo> getCompanyInfo(Integer lastId,Integer size);

    CompanyInfo getCompanyDetailDto(Integer id);

    List<CompanyTeacherInfo> getCompanyTeacherList(Integer id,Integer start);

    CompanyTeacherInfo getCompanyTeacher(Integer id);
}
