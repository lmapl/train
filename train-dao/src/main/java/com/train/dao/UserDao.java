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

    User getUserById(Integer id);

    /**
     * id和想要修改的字段不可为空
     * @param user
     * @return
     */
    int updateById(User user);
}
