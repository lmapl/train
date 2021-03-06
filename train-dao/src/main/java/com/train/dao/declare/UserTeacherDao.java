package com.train.dao.declare;

import com.train.domain.entity.UserTeacher;

import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/2 11:36
 * Description: ${DESCRIPTION}
 */
public interface UserTeacherDao {
    int insert(UserTeacher userTeacher);

    UserTeacher getByUserId(Integer userId);

    int updateByPrimaryKeySelective(UserTeacher userTeacher);

    List<UserTeacher> getTeacherInfo(int lastId, int size);

    UserTeacher getById(Integer id);
}
