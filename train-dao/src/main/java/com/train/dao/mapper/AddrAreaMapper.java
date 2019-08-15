package com.train.dao.mapper;

import com.train.domain.entity.AddrArea;
import com.train.domain.entity.AddrAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddrAreaMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AddrAreaExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AddrAreaExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(AddrArea record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AddrArea record);

    /**
     *
     * @mbggenerated
     */
    List<AddrArea> selectByExample(AddrAreaExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AddrArea record, @Param("example") AddrAreaExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AddrArea record, @Param("example") AddrAreaExample example);
}