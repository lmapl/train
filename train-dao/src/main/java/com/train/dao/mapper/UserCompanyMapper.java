package com.train.dao.mapper;

import com.train.domain.entity.UserCompany;
import com.train.domain.entity.UserCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCompanyMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(UserCompanyExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(UserCompanyExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(UserCompany record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(UserCompany record);

    /**
     *
     * @mbggenerated
     */
    List<UserCompany> selectByExample(UserCompanyExample example);

    /**
     *
     * @mbggenerated
     */
    UserCompany selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") UserCompany record, @Param("example") UserCompanyExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") UserCompany record, @Param("example") UserCompanyExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserCompany record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserCompany record);
}