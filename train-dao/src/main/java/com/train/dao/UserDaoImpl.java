package com.train.dao;

import com.train.dao.example.UserCompanyExample;
import com.train.dao.example.UserExample;
import com.train.dao.mapper.UserMapper;
import com.train.domain.entity.User;
import com.train.utils.Constant;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/30 20:13
 * Description: ${DESCRIPTION}
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private UserMapper userMapper;

    @Override
    public int insert(User record) {

        Date date = new Date();
        record.setCreateby(Constant.SYSTEM_NAME);
        record.setCreatetime(date);
        record.setUpdateby(Constant.SYSTEM_NAME);
        record.setUpdatetime(date);
        userMapper.insert(record);
        return 0;
    }

    @Override
    public List<User> getValidUserByUserName(String userName) {
        if(userName == null){
            return new ArrayList<>();
        }
        UserExample example = new UserExample();
        example.createCriteria().andRegistercertificateEqualTo(userName)
                .andValidEqualTo(1);
        return userMapper.selectByExample(example);
    }
}
