package com.train.dao.mapper;

import com.train.domain.entity.UserStuParent;
import com.train.domain.entity.UserStuParentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserStuParentMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(UserStuParentExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(UserStuParentExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(UserStuParent record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(UserStuParent record);

    /**
     *
     * @mbggenerated
     */
    List<UserStuParent> selectByExample(UserStuParentExample example);

    /**
     *
     * @mbggenerated
     */
    UserStuParent selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") UserStuParent record, @Param("example") UserStuParentExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") UserStuParent record, @Param("example") UserStuParentExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserStuParent record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserStuParent record);
}