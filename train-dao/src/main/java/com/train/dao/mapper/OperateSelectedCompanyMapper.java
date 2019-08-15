package com.train.dao.mapper;

import com.train.domain.entity.OperateSelectedCompany;
import com.train.domain.entity.OperateSelectedCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperateSelectedCompanyMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(OperateSelectedCompanyExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(OperateSelectedCompanyExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(OperateSelectedCompany record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(OperateSelectedCompany record);

    /**
     *
     * @mbggenerated
     */
    List<OperateSelectedCompany> selectByExample(OperateSelectedCompanyExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") OperateSelectedCompany record, @Param("example") OperateSelectedCompanyExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") OperateSelectedCompany record, @Param("example") OperateSelectedCompanyExample example);
}