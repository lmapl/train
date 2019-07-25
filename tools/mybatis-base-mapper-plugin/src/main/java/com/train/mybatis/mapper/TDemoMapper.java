package com.train.mybatis.mapper;

import com.train.mybatis.mapper.TDemo;
import com.train.mybatis.mapper.TDemoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDemoMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(TDemoExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(TDemoExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(TDemo record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(TDemo record);

    /**
     *
     * @mbggenerated
     */
    List<TDemo> selectByExample(TDemoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TDemo record, @Param("example") TDemoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TDemo record, @Param("example") TDemoExample example);
}