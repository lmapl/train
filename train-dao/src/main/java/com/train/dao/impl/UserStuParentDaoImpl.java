package com.train.dao.impl;

import com.train.dao.UserStuParentDao;
import com.train.dao.mapper.UserStuParentMapper;
import com.train.domain.entity.UserStuParent;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/2 11:35
 * Description: ${DESCRIPTION}
 */
@Repository
public class UserStuParentDaoImpl implements UserStuParentDao {

    @Resource
    private UserStuParentMapper userStuParentMapper;


    @Override
    public int insert(UserStuParent userStuParent) {
        return userStuParentMapper.insert(userStuParent);
    }
}
