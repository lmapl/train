package com.train.service.common;

import com.train.domain.bean.CompanyInfo;
import com.train.domain.bean.OperateRecommendInfo;
import com.train.domain.bean.RotationShowInfo;
import com.train.domain.bean.SubjectInfo;

import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/15 14:46
 * Description: ${DESCRIPTION}
 * 运营管理类
 */
public interface OperateService {

    List<RotationShowInfo> getRotationShowByLocation(int location);

    List<OperateRecommendInfo> getRecommendByLocation(int location);

    /**
     * 获取精选机构
     * @return
     */
    List<CompanyInfo> getSelectedCompanyByLocation(int location);

    List<SubjectInfo> getSubject();
}
