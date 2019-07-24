package com.train.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.io.Serializable;
import java.util.List;

/**
 * 基类 mapper
 * @param <T>
 * @param <PK>
 */

public interface BaseMapper<T, C, PK extends Serializable> {

    int deleteByPrimaryKey(PK pk);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(PK pk);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    long countByExample(C Criteria);

    int deleteByExample(C example);

    List<T> selectByExampleWithRowbounds(C example, RowBounds rowBounds);

    List<T> selectByExample(C example);

    int updateByExampleSelective(@Param("record") T record, @Param("example") C example);

    int updateByExample(@Param("record") T record, @Param("example") C example);
}