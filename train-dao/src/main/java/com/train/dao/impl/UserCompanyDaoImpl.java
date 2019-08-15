package com.train.dao.impl;

import com.train.dao.declare.UserCompanyDao;
import com.train.dao.mapper.UserCompanyMapper;
import com.train.domain.entity.UserCompany;
import com.train.domain.entity.UserCompanyExample;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<UserCompany> getByIdList(List<Integer> idList) {
        if(CollectionUtils.isEmpty(idList)){
            return null;
        }
        UserCompanyExample example = new UserCompanyExample();
        example.createCriteria().andIdIn(idList);
        return userCompanyMapper.selectByExample(example);
    }

    @Override
    public List<UserCompany> getCompanyInfo(Integer lastId, Integer size) {
        UserCompanyExample example = new UserCompanyExample();
        example.createCriteria().andIdGreaterThan(lastId);
        example.setOrderByClause(" create_time desc limit "+size);
        return userCompanyMapper.selectByExample(example);
    }
}
