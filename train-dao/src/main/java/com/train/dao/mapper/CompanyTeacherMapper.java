package com.train.dao.mapper;

import com.train.domain.entity.CompanyTeacher;
import com.train.domain.entity.CompanyTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyTeacherMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(CompanyTeacherExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(CompanyTeacherExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(CompanyTeacher record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(CompanyTeacher record);

    /**
     *
     * @mbggenerated
     */
    List<CompanyTeacher> selectByExample(CompanyTeacherExample example);

    /**
     *
     * @mbggenerated
     */
    CompanyTeacher selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CompanyTeacher record, @Param("example") CompanyTeacherExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CompanyTeacher record, @Param("example") CompanyTeacherExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CompanyTeacher record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CompanyTeacher record);
}