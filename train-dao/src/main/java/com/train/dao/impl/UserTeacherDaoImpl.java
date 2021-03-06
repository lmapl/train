package com.train.dao.impl;

import com.train.dao.declare.UserTeacherDao;
import com.train.dao.mapper.UserTeacherMapper;
import com.train.domain.entity.UserTeacher;
import com.train.domain.entity.UserTeacherExample;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public UserTeacher getByUserId(Integer userId) {
        return userTeacherMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(UserTeacher userTeacher) {
        return userTeacherMapper.updateByPrimaryKeySelective(userTeacher);
    }

    @Override
    public List<UserTeacher> getTeacherInfo(int lastId, int size) {
        UserTeacherExample example = new UserTeacherExample();
        example.createCriteria().andIdGreaterThan(lastId);
        example.setOrderByClause(" create_time desc limit "+size);
        return userTeacherMapper.selectByExample(example);
    }

    @Override
    public UserTeacher getById(Integer id) {
        UserTeacherExample example = new UserTeacherExample();
        example.createCriteria().andIdEqualTo(id);
        List<UserTeacher> userTeachers = userTeacherMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(userTeachers)){
            return null;
        }
        return userTeachers.get(0);
    }
}
