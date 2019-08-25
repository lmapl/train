package com.train.dao.mapper;

import com.train.domain.entity.UserCompanyImage;
import com.train.domain.entity.UserCompanyImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCompanyImageMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(UserCompanyImageExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(UserCompanyImageExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(UserCompanyImage record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(UserCompanyImage record);

    /**
     *
     * @mbggenerated
     */
    List<UserCompanyImage> selectByExample(UserCompanyImageExample example);

    /**
     *
     * @mbggenerated
     */
    UserCompanyImage selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") UserCompanyImage record, @Param("example") UserCompanyImageExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") UserCompanyImage record, @Param("example") UserCompanyImageExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserCompanyImage record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserCompanyImage record);
}