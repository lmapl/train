package com.train.dao.impl;

import com.train.dao.UserTeacherDao;
import com.train.dao.mapper.UserTeacherMapper;
import com.train.domain.entity.UserTeacher;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/2 11:36
 * Description: ${DESCRIPTION}
 */
@Repository
public class UserTeacherDaoImpl implements UserTeacherDao {

    @Resource
    private UserTeacherMapper userTeacherMapper;

    @Override
    public int insert(UserTeacher userTeacher) {
        return userTeacherMapper.insert(userTeacher);
    }
}
