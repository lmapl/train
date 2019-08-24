package com.train.service.teacher;

import com.train.domain.bean.TeacherInfo;

import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/24 17:38
 * Description: ${DESCRIPTION}
 */
public interface TeacherService {

    List<TeacherInfo> getTeacherList(int i, int i1);

    TeacherInfo getTeacherInfo(Integer id);
}
