package com.train.dao.impl;

import com.train.dao.OperateSelectedCompanyDao;
import com.train.dao.mapper.OperateSelectedCompanyMapper;
import com.train.domain.entity.OperateSelectedCompany;
import com.train.domain.entity.OperateSelectedCompanyExample;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/13 17:07
 * Description: ${DESCRIPTION}
 */
@Repository
public class OperateSelectedCompanyDaoImpl implements OperateSelectedCompanyDao {

    @Resource
    private OperateSelectedCompanyMapper companySelectedMapper;

    @Override
    public List<OperateSelectedCompany> getSelectedCompany(int location) {
        OperateSelectedCompanyExample example = new OperateSelectedCompanyExample();
        example.createCriteria().andLocationEqualTo(location);
        return companySelectedMapper.selectByExample(example);
    }
}
