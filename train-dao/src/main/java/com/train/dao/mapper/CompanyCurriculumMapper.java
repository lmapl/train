package com.train.dao.mapper;

import com.train.domain.entity.CompanyCurriculum;
import com.train.domain.entity.CompanyCurriculumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyCurriculumMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(CompanyCurriculumExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(CompanyCurriculumExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(CompanyCurriculum record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(CompanyCurriculum record);

    /**
     *
     * @mbggenerated
     */
    List<CompanyCurriculum> selectByExample(CompanyCurriculumExample example);

    /**
     *
     * @mbggenerated
     */
    CompanyCurriculum selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CompanyCurriculum record, @Param("example") CompanyCurriculumExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CompanyCurriculum record, @Param("example") CompanyCurriculumExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CompanyCurriculum record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CompanyCurriculum record);
}