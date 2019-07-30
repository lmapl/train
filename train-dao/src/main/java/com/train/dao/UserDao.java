package com.train.dao;

import com.train.domain.entity.User;

import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/30 20:13
 * Description: ${DESCRIPTION}
 */
public interface UserDao {

    int insert(User record);

    List<User> getValidUserByUserName(String userName);
}
