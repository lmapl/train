package com.train.dao.mapper;

import com.train.domain.entity.OperateRotationShow;
import com.train.domain.entity.OperateRotationShowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperateRotationShowMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(OperateRotationShowExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(OperateRotationShowExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(OperateRotationShow record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(OperateRotationShow record);

    /**
     *
     * @mbggenerated
     */
    List<OperateRotationShow> selectByExample(OperateRotationShowExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") OperateRotationShow record, @Param("example") OperateRotationShowExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") OperateRotationShow record, @Param("example") OperateRotationShowExample example);
}