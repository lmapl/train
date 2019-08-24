package com.train.dao.declare;

import com.train.domain.entity.UserCompany;

import java.util.List;
/**
 * Created by ma peiliang
 * Create Date: 2019/8/2 11:37
 * Description: ${DESCRIPTION}
 */
public interface UserCompanyDao {
    int insert(UserCompany userCompany);

    UserCompany getByUserId(Integer userId);

    int updateByPrimaryKeySelective(UserCompany userCompany);

    List<UserCompany> getByIdList(List<Integer> idList);

    List<UserCompany> getCompanyInfo(Integer lastId, Integer size);

    UserCompany getById(Integer id);
}
