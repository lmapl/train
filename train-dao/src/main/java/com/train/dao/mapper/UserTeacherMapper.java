package com.train.dao.mapper;

import com.train.dao.example.UserTeacherExample;
import com.train.domain.entity.UserTeacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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