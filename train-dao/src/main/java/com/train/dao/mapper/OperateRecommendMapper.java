package com.train.dao.mapper;

import com.train.domain.entity.OperateRecommend;
import com.train.domain.entity.OperateRecommendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperateRecommendMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(OperateRecommendExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(OperateRecommendExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(OperateRecommend record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(OperateRecommend record);

    /**
     *
     * @mbggenerated
     */
    List<OperateRecommend> selectByExample(OperateRecommendExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") OperateRecommend record, @Param("example") OperateRecommendExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") OperateRecommend record, @Param("example") OperateRecommendExample example);
}