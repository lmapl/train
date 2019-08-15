package com.train.dao.mapper;

import com.train.domain.entity.Subject;
import com.train.domain.entity.SubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubjectMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(SubjectExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(SubjectExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(Subject record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(Subject record);

    /**
     *
     * @mbggenerated
     */
    List<Subject> selectByExample(SubjectExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Subject record, @Param("example") SubjectExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Subject record, @Param("example") SubjectExample example);
}