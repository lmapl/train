package com.train.dao.declare;

import com.train.domain.entity.UserCompanyImage;

import java.util.List;

public interface UserCompanyImageDao  {
    void delByUserCompanyId(Integer id);

    void insert(UserCompanyImage image);

    List<UserCompanyImage> getByUserCompanyId(Integer id);
}
