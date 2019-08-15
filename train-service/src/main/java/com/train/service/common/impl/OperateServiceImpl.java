package com.train.service.common.impl;

import com.train.dao.OperateRecommendDao;
import com.train.dao.OperateRotationShowDao;
import com.train.dao.OperateSelectedCompanyDao;
import com.train.dao.UserCompanyDao;
import com.train.domain.bean.CompanyInfo;
import com.train.domain.bean.OperateRecommendInfo;
import com.train.domain.bean.RotationShowInfo;
import com.train.domain.entity.OperateRecommend;
import com.train.domain.entity.OperateRotationShow;
import com.train.domain.entity.OperateSelectedCompany;
import com.train.domain.entity.UserCompany;
import com.train.service.common.OperateService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/15 14:47
 * Description: ${DESCRIPTION}
 */
@Service
public class OperateServiceImpl implements OperateService {

    @Resource
    private OperateRotationShowDao rotationShowDao;

    @Resource
    private OperateRecommendDao operateRecommendDao;

    @Resource
    private OperateSelectedCompanyDao selectedCompanyDao;


    @Resource
    private UserCompanyDao userCompanyDao;

    @Override
    public List<RotationShowInfo> getRotationShowByLocation(int location) {
        List<OperateRotationShow> rotationShowList = rotationShowDao.getRotationShow(location);
        List<RotationShowInfo> rotationShowInfos = new ArrayList<>();
        RotationShowInfo info ;
        for(OperateRotationShow rotationShow : rotationShowList){
            info = new RotationShowInfo();
            BeanUtils.copyProperties(rotationShow,info);
            rotationShowInfos.add(info);
        }
        return rotationShowInfos;
    }

    @Override
    public List<OperateRecommendInfo> getRecommendByLocation(int location) {
        List<OperateRecommend> operateRecommendList = operateRecommendDao.getRecommendByLocation(location);

        if(CollectionUtils.isEmpty(operateRecommendList)){
            return new ArrayList<>();
        }
        List<OperateRecommendInfo> infoList = new ArrayList<>();
        OperateRecommendInfo info;
        for(OperateRecommend recommend : operateRecommendList){
            info = new OperateRecommendInfo();
            BeanUtils.copyProperties(recommend,info);
            infoList.add(info);
        }
        return infoList;
    }

    @Override
    public List<CompanyInfo> getSelectedCompanyByLocation(int location){

        List<OperateSelectedCompany> selectedList =  selectedCompanyDao.getSelectedCompany(location);
        if(CollectionUtils.isEmpty(selectedList)){
            return new ArrayList<>();
        }
        List<Integer> idList = selectedList.stream().map(OperateSelectedCompany::getCompanyId).collect(Collectors.toList());

        List<UserCompany>  userCompanyList = userCompanyDao.getByIdList(idList);

        List<CompanyInfo> companyInfoList = new ArrayList<>();
        CompanyInfo companyInfo;
        for(UserCompany userCompany : userCompanyList){
            companyInfo = new CompanyInfo();
            companyInfo.setId(userCompany.getId());
            companyInfo.setName(userCompany.getNickname());
            companyInfo.setPortrait(userCompany.getPortrait());
            companyInfoList.add(companyInfo);
        }
        return companyInfoList;
    }
}
