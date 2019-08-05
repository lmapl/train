package com.train.dao;

import com.train.domain.entity.UserCompany; /**
 * Created by ma peiliang
 * Create Date: 2019/8/2 11:37
 * Description: ${DESCRIPTION}
 */
public interface UserCompanyDao {
    int insert(UserCompany userCompany);

    UserCompany getByUserId(Integer userId);

    int updateByPrimaryKeySelective(UserCompany userCompany);
}
