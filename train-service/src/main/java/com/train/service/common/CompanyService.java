package com.train.service.common;

import com.train.domain.bean.CompanyTeacherInfo; /**
 * Created by ma peiliang
 * Create Date: 2019/8/3 17:19
 * Description: ${DESCRIPTION}
 */
public interface CompanyService {
    Boolean addTeacher(String autograph, CompanyTeacherInfo teacherInfo);

    Boolean modifyTeacher(String autograph, CompanyTeacherInfo teacherInfo);
}
