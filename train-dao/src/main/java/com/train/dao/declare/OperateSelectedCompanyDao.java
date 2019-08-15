package com.train.dao.declare;

import com.train.domain.entity.OperateSelectedCompany;

import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/13 17:07
 * Description: ${DESCRIPTION}
 */
public interface OperateSelectedCompanyDao {
    List<OperateSelectedCompany> getSelectedCompany(int location);
}
