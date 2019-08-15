package com.train.dao.mapper;

import com.train.domain.entity.UserTeacher;
import com.train.domain.entity.UserTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTeacherMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(UserTeacherExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(UserTeacherExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(UserTeacher record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(UserTeacher record);

    /**
     *
     * @mbggenerated
     */
    List<UserTeacher> selectByExample(UserTeacherExample example);

    /**
     *
     * @mbggenerated
     */
    UserTeacher selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") UserTeacher record, @Param("example") UserTeacherExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") UserTeacher record, @Param("example") UserTeacherExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserTeacher record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserTeacher record);
}