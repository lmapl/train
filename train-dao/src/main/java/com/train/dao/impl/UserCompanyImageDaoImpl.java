package com.train.dao.impl;

import com.train.dao.declare.UserCompanyImageDao;
import com.train.dao.mapper.UserCompanyImageMapper;
import com.train.domain.entity.UserCompanyImage;
import com.train.domain.entity.UserCompanyImageExample;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Repository
public class UserCompanyImageDaoImpl implements UserCompanyImageDao {

    @Resource
    private UserCompanyImageMapper userCompanyImageMapper;

    @Override
    public void delByUserCompanyId(Integer id) {

        UserCompanyImageExample example = new UserCompanyImageExample();
        example.createCriteria().andUserCompanyIdEqualTo(id);
        userCompanyImageMapper.deleteByExample(example);
    }

    @Override
    public void insert(UserCompanyImage image) {
        image.setCreateBy("admin");
        image.setCreateTime(new Date());
        image.setUpdateBy("admin");
        image.setUpdateTime(new Date());
        userCompanyImageMapper.insert(image);
    }

    @Override
    public List<UserCompanyImage> getByUserCompanyId(Integer id) {
        UserCompanyImageExample example = new UserCompanyImageExample();
        example.createCriteria().andUserCompanyIdEqualTo(id);
        return  userCompanyImageMapper.selectByExample(example);
    }
}
