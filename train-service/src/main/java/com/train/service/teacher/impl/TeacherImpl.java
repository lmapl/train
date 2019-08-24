package com.train.service.teacher.impl;

import com.train.dao.declare.UserTeacherDao;
import com.train.domain.bean.CompanyInfo;
import com.train.domain.bean.TeacherInfo;
import com.train.domain.entity.UserCompany;
import com.train.domain.entity.UserTeacher;
import com.train.service.teacher.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/24 17:39
 * Description: ${DESCRIPTION}
 */
@Service
public class TeacherImpl implements TeacherService {

    @Resource
    private UserTeacherDao userTeacherDao;
    @Override
    public List<TeacherInfo> getTeacherList(int lastId, int size) {
        List<UserTeacher> userTeacherList = userTeacherDao.getTeacherInfo(lastId,size);
        if(CollectionUtils.isEmpty(userTeacherList)){
            return new ArrayList<>();
        }

        List<TeacherInfo> teacherInfoList = new ArrayList<>();
        TeacherInfo teacherInfo ;
        for(UserTeacher userTeacher : userTeacherList){
            teacherInfo = new TeacherInfo();
            BeanUtils.copyProperties(userTeacher,teacherInfo);
            teacherInfoList.add(teacherInfo);
        }
        return teacherInfoList;
    }

    @Override
    public TeacherInfo getTeacherInfo(Integer id) {
        UserTeacher teacher = userTeacherDao.getById(id);
        if(teacher == null){
            return null;
        }
        TeacherInfo info = new TeacherInfo();
        BeanUtils.copyProperties(teacher,info);
        return info;
    }
}
