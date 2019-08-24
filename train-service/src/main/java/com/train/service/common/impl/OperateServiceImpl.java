package com.train.service.common.impl;

import com.train.dao.declare.*;
import com.train.domain.bean.*;
import com.train.domain.entity.*;
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

    @Resource
    private SubjectDao subjectDao;

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
            companyInfo.setName(userCompany.getNickName());
            companyInfo.setPortrait(userCompany.getPortrait());
            companyInfoList.add(companyInfo);
        }
        return companyInfoList;
    }

    @Override
    public List<SubjectInfo> getSubject() {
        List<Subject> subjectList =  subjectDao.getAll();

        List<SubjectInfo> subjectInfoList = new ArrayList<>();
        SubjectInfo subjectInfo;
        for(Subject subject : subjectList){
            subjectInfo = new SubjectInfo();
            BeanUtils.copyProperties(subject,subjectInfo);
            subjectInfoList.add(subjectInfo);
        }
        return subjectInfoList;
    }

    @Override
    public List<TeacherInfo> getSelectedTeacherByLocation(int location) {
        return null;
    }
}
