package com.train.service.common.impl;

import com.train.dao.CompanyCurriculumDao;
import com.train.dao.CompanyTeacherDao;
import com.train.dao.UserCompanyDao;
import com.train.dao.UserDao;
import com.train.domain.bean.CompanyCurriculumInfo;
import com.train.domain.bean.CompanyTeacherInfo;
import com.train.domain.bean.UserSessionInfo;
import com.train.domain.entity.CompanyCurriculum;
import com.train.domain.entity.CompanyTeacher;
import com.train.domain.entity.User;
import com.train.domain.enums.UserStatusEnum;
import com.train.domain.enums.UserTypeEnum;
import com.train.service.common.CompanyService;
import com.train.service.common.TokenService;
import com.train.utils.Constant;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/3 17:19
 * Description: ${DESCRIPTION}
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Resource
    private TokenService tokenService;

    @Resource
    private CompanyTeacherDao companyTeacherDao;

    @Resource
    private CompanyCurriculumDao companyCurriculumDao;

    @Resource
    private UserDao userDao;

    @Override
    public Boolean addTeacher(String autograph, CompanyTeacherInfo teacherInfo) {

        if(StringUtils.isEmpty(autograph) || teacherInfo == null ){
            return false;
        }

        UserSessionInfo session = tokenService.verifyLoginToken(autograph);
        if(session == null || session.getSessionId() == null){
            return false;
        }
        //判断用户有效
        User user = userDao.getUserById(session.getUserId());
        if(user == null || user.getUserType() != UserTypeEnum.COMPANY.getKey() || user.getStatus() != UserStatusEnum.VALID.getKey()){
            return false;
        }

        CompanyTeacher companyTeacher = new CompanyTeacher();
        companyTeacher.setCompanyId(session.getUserId());
        companyTeacher.setFreeVideo(teacherInfo.getFreeVideo());
        companyTeacher.setIntroduction(teacherInfo.getIntroduction());
        companyTeacher.setNickName(teacherInfo.getNickName());
        companyTeacher.setPortrait(teacherInfo.getPortrait());
        companyTeacher.setPosition(teacherInfo.getPosition());
        companyTeacher.setSubjectId(teacherInfo.getSubject());
        companyTeacher.setTeachingAge(teacherInfo.getTeachingAge());
        return companyTeacherDao.insert(companyTeacher)==1;
    }

    @Override
    public Boolean modifyTeacher(String autograph, CompanyTeacherInfo teacherInfo) {

        if(StringUtils.isEmpty(autograph) || teacherInfo == null ){
            return false;
        }

        UserSessionInfo session = tokenService.verifyLoginToken(autograph);
        if(session == null || session.getSessionId() == null){
            return false;
        }
        //判断用户有效
        User user = userDao.getUserById(session.getUserId());
        if(user == null || user.getUserType() != UserTypeEnum.COMPANY.getKey() || user.getStatus() != UserStatusEnum.VALID.getKey()){
            return false;
        }

        CompanyTeacher companyTeacher = companyTeacherDao.getById(teacherInfo.getId());
        if(companyTeacher == null
                || companyTeacher.getCompanyId().intValue() != user.getId()){
            return false;
        }

        companyTeacher.setTeachingAge(teacherInfo.getTeachingAge());
        companyTeacher.setSubjectId(teacherInfo.getSubject());
        companyTeacher.setPosition(teacherInfo.getPosition());
        companyTeacher.setPortrait(teacherInfo.getPortrait());
        companyTeacher.setNickName(teacherInfo.getNickName());
        companyTeacher.setIntroduction(teacherInfo.getIntroduction());
        companyTeacher.setFreeVideo(teacherInfo.getFreeVideo());
        companyTeacher.setUpdateBy(Constant.SYSTEM_NAME);
        companyTeacher.setUpdateTime(new Date());

        int num = companyTeacherDao.updateByPrimaryKeySelective(companyTeacher);
        return num == 1;
    }

    @Override
    public Boolean addCurriculum(String autograph, CompanyCurriculumInfo info) {

        if(StringUtils.isEmpty(autograph) || info == null ){
            return false;
        }

        UserSessionInfo session = tokenService.verifyLoginToken(autograph);
        if(session == null || session.getSessionId() == null){
            return false;
        }
        //判断用户有效
        User user = userDao.getUserById(session.getUserId());
        if(user == null || user.getUserType() != UserTypeEnum.COMPANY.getKey() || user.getStatus() != UserStatusEnum.VALID.getKey()){
            return false;
        }

        CompanyTeacher companyTeacher = companyTeacherDao.getById(info.getCompanyTeacherId());
        if(companyTeacher == null || companyTeacher.getCompanyId().intValue() != user.getId()){
            return false;
        }

        CompanyCurriculum  companyCurriculum = new CompanyCurriculum();
        companyCurriculum.setCompanyTeacherId(info.getCompanyTeacherId());
        companyCurriculum.setContactTel(info.getContactTel());
        companyCurriculum.setCurriculumName(info.getCurriculumName());
        companyCurriculum.setStartTime(info.getStartTime());
        companyCurriculum.setEndTime(info.getEndTime());
        companyCurriculum.setTeachingTime(info.getTeachingTime());

        companyCurriculum.setMaxNumber(info.getMaxNumber());
        companyCurriculum.setMinNumber(info.getMinNumber());
        companyCurriculum.setPeriod(info.getPeriod());
        companyCurriculum.setPrice(info.getPrice());
        companyCurriculum.setRemark(info.getRemark());
        companyCurriculum.setSubjectId(info.getSubjectId());
        companyCurriculum.setCreateBy(Constant.SYSTEM_NAME);
        companyCurriculum.setCreateTime(new Date());
        companyCurriculum.setUpdateBy(Constant.SYSTEM_NAME);
        companyCurriculum.setUpdateTime(new Date());

        int num = companyCurriculumDao.insert(companyCurriculum);
        return num == 1;
    }
}
