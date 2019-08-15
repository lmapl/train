package com.train.dao.declare;

import com.train.domain.entity.UserStuParent; /**
 * Created by ma peiliang
 * Create Date: 2019/8/2 11:35
 * Description: ${DESCRIPTION}
 */
public interface UserStuParentDao {
    int insert(UserStuParent userStuParent);

    UserStuParent getByUserId(Integer userId);

    int updateByPrimaryKeySelective(UserStuParent userStuParent);
}
