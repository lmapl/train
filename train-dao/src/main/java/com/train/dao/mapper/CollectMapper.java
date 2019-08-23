package com.train.dao.mapper;

import com.train.domain.entity.Collect;
import com.train.domain.entity.CollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(CollectExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(CollectExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(Collect record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(Collect record);

    /**
     *
     * @mbggenerated
     */
    List<Collect> selectByExample(CollectExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Collect record, @Param("example") CollectExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Collect record, @Param("example") CollectExample example);
}