package com.train.dao.mapper;

import com.train.domain.entity.DynamicEvent;
import com.train.domain.entity.DynamicEventExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DynamicEventMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(DynamicEventExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(DynamicEventExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(DynamicEvent record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(DynamicEvent record);

    /**
     *
     * @mbggenerated
     */
    List<DynamicEvent> selectByExample(DynamicEventExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") DynamicEvent record, @Param("example") DynamicEventExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") DynamicEvent record, @Param("example") DynamicEventExample example);
}