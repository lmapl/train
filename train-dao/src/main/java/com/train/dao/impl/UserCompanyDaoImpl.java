package com.train.dao.impl;

import com.train.dao.UserCompanyDao;
import com.train.dao.mapper.UserCompanyMapper;
import com.train.domain.entity.UserCompany;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/2 11:37
 * Description: ${DESCRIPTION}
 */
@Repository
public class UserCompanyDaoImpl implements UserCompanyDao {

    @Resource
    private UserCompanyMapper userCompanyMapper;

    @Override
    public int insert(UserCompany userCompany) {
        return userCompanyMapper.insert(userCompany);
    }

    @Override
    public UserCompany getByUserId(Integer userId) {
        return userCompanyMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(UserCompany userCompany) {
        return userCompanyMapper.updateByPrimaryKeySelective(userCompany);
    }
}
