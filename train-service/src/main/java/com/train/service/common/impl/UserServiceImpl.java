package com.train.service.common.impl;

import com.train.Exception.AuthException;
import com.train.Exception.InternalServerException;
import com.train.dao.declare.UserCompanyDao;
import com.train.dao.declare.UserDao;
import com.train.dao.declare.UserStuParentDao;
import com.train.dao.declare.UserTeacherDao;
import com.train.domain.bean.*;
import com.train.domain.entity.User;
import com.train.domain.entity.UserCompany;
import com.train.domain.entity.UserStuParent;
import com.train.domain.entity.UserTeacher;
import com.train.domain.enums.TokenTypeEnum;
import com.train.domain.enums.UserStatusEnum;
import com.train.domain.enums.UserTypeEnum;
import com.train.redis.RedisKey;
import com.train.service.ConstantRedis;
import com.train.service.common.*;
import com.train.utils.Constant;
import com.train.utils.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/30 19:48
 * Description: ${DESCRIPTION}
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private RsaService rsaService;

    @Resource
    private MobileService mobileService;

    @Resource
    private TokenService tokenService;

    @Resource
    private UserDao userDao;

    @Resource
    private UserStuParentDao userStuParentDao;

    @Resource
    private UserTeacherDao userTeacherDao;

    @Resource
    private UserCompanyDao userCompanyDao;


    @Resource
    private RedisService redisService;

    @Override
    public boolean register(RegisterInfo registerInfo) {
        Integer type = registerInfo.getType();
        Integer platform = registerInfo.getPlatform();
        String uuid = rsaService.decryptByPrivateKey(registerInfo.getUuid());
        String userName = rsaService.decryptByPrivateKey(registerInfo.getUserName());
        String password = rsaService.decryptByPrivateKey(registerInfo.getPassword());
        if(1 == type){
            String  mobileVerifyCode  = rsaService.decryptByPrivateKey(registerInfo.getMobileVerifyCode());
            if(!mobileService.verifyCode(userName,mobileVerifyCode)){
                throw new AuthException("手机验证码鉴权不通过");
            }
        }

        List<User> userList =  userDao.getValidUserByUserName(userName);
        if(!CollectionUtils.isEmpty(userList)){
            throw new AuthException("用户名已经注册");
        }

        User user = new User();
        user.setPlatform(platform);
        user.setDeviceUuid(uuid);
        user.setRegisterCertificate(userName);
        user.setRegisterType(type);
        user.setPassword(password);
        user.setUserType(UserTypeEnum.PENDING.getKey());
        user.setStatus(UserStatusEnum.VALID.getKey());
        return userDao.insert(user) == 1;
    }

    @Override
    public User mobileLoginVerify(LoginInfo loginInfo) {
        if(loginInfo == null
                || (loginInfo.getType() == null || loginInfo.getType() != 1)
                || loginInfo.getAutograph() == null
                || loginInfo.getUserName() == null
                || (loginInfo.getMobileVerifyCode() == null && loginInfo.getPassword() == null)){
            return null;
        }

        //验证autograph
        boolean autograph = tokenService.verifyNotLoginToken(TokenTypeEnum.LOGIN.getKey(),loginInfo.getAutograph());
        if(!autograph){
            return null;
        }

        //验证该用户名是否有有效注册记录
        String userName = rsaService.decryptByPrivateKey(loginInfo.getUserName());
        List<User> userList =  userDao.getValidUserByUserName(userName);
        if(CollectionUtils.isEmpty(userList)){
           return null;
        }

        if(userList.size() != 1){
            throw new InternalServerException("系统业务异常：一个用户凭证只可以有一条有效数据");
        }
        User user = userList.get(0);

        //如果密码不为空，则验证密码是否匹配
        if(loginInfo.getPassword() != null){
            String password = rsaService.decryptByPrivateKey(loginInfo.getPassword());
            return user.getPassword().equals(password) ? user : null;
        }

        //如果短信验证不为空，则验证短信验证码是否匹配
        if(loginInfo.getMobileVerifyCode() != null){
            String mobileVerifyCode = rsaService.decryptByPrivateKey(loginInfo.getMobileVerifyCode());
            return mobileService.verifyCode(userName,mobileVerifyCode) ? user : null;
        }
        return null;
    }

    @Override
    public String login(User user) {

        //生成不重复sessionid
        String sessionId;
        Long time = System.currentTimeMillis();
        RedisKey redisKey = ConstantRedis.REDIS_INCR_NUM(DateUtil.format(new Date(),DateUtil.YMD_FORMAT));
        long num = redisService.incrBy(redisKey.getKey(),1);
        redisService.expire(redisKey.getKey(),redisKey.getExpireSeconds());
        sessionId = time+""+num;

        return tokenService.getLoginToken(user.getId(),user.getRegisterCertificate(),user.getPlatform(),user.getDeviceUuid(),sessionId);
    }

    @Override
    public Boolean loginOut(String autograph) {
        if(StringUtils.isEmpty(autograph)){
            return false;
        }
        return tokenService.loginOut(autograph);
    }

    @Override
    public Boolean bindMobile(String autograph, String mobile, String mobileCode) {
        if(StringUtils.isEmpty(autograph)
                || StringUtils.isEmpty(mobile)
                || StringUtils.isEmpty(mobileCode) ){
            return false;
        }

        //验证手机验证码
        mobile =  rsaService.decryptByPrivateKey(mobile);
        mobileCode =  rsaService.decryptByPrivateKey(mobileCode);
        if(!mobileService.verifyCode(mobile,mobileCode)){
            throw new AuthException("手机验证码鉴权不通过");
        }

        List<User> userList =  userDao.getValidUserByUserName(mobile);
        if(CollectionUtils.isEmpty(userList)){
            return null;
        }

        return null;
    }

    @Override
    @Transactional
    public Boolean userTypeConfirm(String autograph, Integer type) {
        /*if(StringUtils.isEmpty(autograph) || type == null ){
            return false;
        }

        UserSessionInfo session = tokenService.verifyLoginToken(autograph);
        if(session == null || session.getSessionId() == null){
            return false;
        }

        User user = userDao.getUserById(session.getUserId());
        if(user.getUserType() != 0){
            return false;
        }
*/
        Integer userId = 6;
         type = 1;
        if(!initUserTypeDetail(userId,type)){
            return false;
        }


        User userTemp = new User();
        userTemp.setId(userId);
        userTemp.setUserType(type);
        userTemp.setUpdateTime(new Date());
        userTemp.setUpdateBy(Constant.SYSTEM_NAME);

        //生成对应的详细表记录
        return userDao.updateById(userTemp) == 1;
    }

    @Override
    public Boolean labelConfirm(String autograph, Integer educateLevel,Integer grade) {
        if(StringUtils.isEmpty(autograph) || educateLevel == null  || grade == null){
            return false;
        }

        UserSessionInfo session = tokenService.verifyLoginToken(autograph);
        if(session == null){
            return false;
        }
        Integer userId = session.getUserId();

        User user = new User();
        user.setId(userId);
        user.setEducateLevel(educateLevel);
        user.setGrade(grade);
        user.setUpdateTime(new Date());
        user.setUpdateBy(Constant.SYSTEM_NAME);
        return userDao.updateById(user) == 1;
    }

    //@Override
    //@Transactional
    private Boolean initUserTypeDetail(Integer userId, Integer type) {
        if(userId == null ||type == null){
            return false;
        }

        Date date = new Date();
        if(UserTypeEnum.STU_PARENT.getKey() == type){
            UserStuParent userStuParent =   userStuParentDao.getByUserId(userId);
            if(userStuParent == null ){
                userStuParent = new UserStuParent();
                userStuParent.setId(userId);
                userStuParent.setCreateBy(Constant.SYSTEM_NAME);
                userStuParent.setCreateTime(date);
                userStuParent.setUpdateBy(Constant.SYSTEM_NAME);
                userStuParent.setUpdateTime(date);
                return userStuParentDao.insert(userStuParent) == 1;
            }
        }else if(UserTypeEnum.TEACHER.getKey() == type){
            UserTeacher userTeacher =  userTeacherDao.getByUserId(userId);
            if(userTeacher == null){
                 userTeacher = new UserTeacher();
                userTeacher.setId(userId);
                userTeacher.setCreateBy(Constant.SYSTEM_NAME);
                userTeacher.setCreateTime(date);
                userTeacher.setUpdateBy(Constant.SYSTEM_NAME);
                userTeacher.setUpdateTime(date);
                return userTeacherDao.insert(userTeacher) == 1;
            }

        }else if(UserTypeEnum.COMPANY.getKey() == type){
            UserCompany userCompany = userCompanyDao.getByUserId(userId);
            if(userCompany == null){
                userCompany = new UserCompany();
                userCompany.setId(userId);
                userCompany.setCreateBy(Constant.SYSTEM_NAME);
                userCompany.setCreateTime(date);
                userCompany.setUpdateBy(Constant.SYSTEM_NAME);
                userCompany.setUpdateTime(date);
                return userCompanyDao.insert(userCompany) == 1;
            }

        }else {
            return false;
        }

        return true;
    }

    @Override
    public Boolean userStuImproveInfo(ImproveInfo improveInfo) {
        if(StringUtils.isEmpty(improveInfo.getAutograph())){
            return false;
        }

        UserSessionInfo session = tokenService.verifyLoginToken(improveInfo.getAutograph());
        if(session == null){
            return false;
        }

        UserStuParent userStuParent = userStuParentDao.getByUserId(session.getUserId());
        if(userStuParent == null){
            return false;
        }

        userStuParent.setNickname(improveInfo.getNickName());
        userStuParent.setPortrait(improveInfo.getPortrait());
        userStuParent.setBirthdayYear(improveInfo.getBirthdayYear());
        userStuParent.setBirthdayMonth(improveInfo.getBirthdayMonth());
        userStuParent.setBirthdayDay(improveInfo.getBirthdayDay());
        userStuParent.setGender(improveInfo.getGender());
        userStuParent.setUpdateBy(Constant.SYSTEM_NAME);
        userStuParent.setUpdateTime(new Date());

        //修改学生家长明细
        return userStuParentDao.updateByPrimaryKeySelective(userStuParent) == 1;
    }

    @Override
    public Boolean teacherImproveInfo(ImproveInfo improveInfo) {

        if(StringUtils.isEmpty(improveInfo.getAutograph())){
            return false;
        }

        UserSessionInfo session = tokenService.verifyLoginToken(improveInfo.getAutograph());
        if(session == null){
            return false;
        }

        UserTeacher userTeacher = userTeacherDao.getByUserId(session.getUserId());
        if(userTeacher == null){
            return false;
        }

        userTeacher.setNickName(improveInfo.getNickName());
        userTeacher.setPortrait(improveInfo.getPortrait());
        userTeacher.setSubjectId(improveInfo.getSubject());
        userTeacher.setTeachingAge(improveInfo.getTeachingAge());
        userTeacher.setPosition(improveInfo.getPosition());
        userTeacher.setIntroduction(improveInfo.getIntroduction());
        userTeacher.setFreeVideo(improveInfo.getFreeVideo());
        userTeacher.setUpdateBy(Constant.SYSTEM_NAME);
        userTeacher.setUpdateTime(new Date());

        //修改学生家长明细
        return userTeacherDao.updateByPrimaryKeySelective(userTeacher) == 1;
    }

    @Override
    public Boolean companyImproveInfo(ImproveInfo improveInfo) {
        if(StringUtils.isEmpty(improveInfo.getAutograph())){
            return false;
        }

        UserSessionInfo session = tokenService.verifyLoginToken(improveInfo.getAutograph());
        if(session == null){
            return false;
        }

        UserCompany userCompany = userCompanyDao.getByUserId(session.getUserId());
        if(userCompany == null){
            return false;
        }

        userCompany.setNickName(improveInfo.getNickName());
        userCompany.setPortrait(improveInfo.getPortrait());
        userCompany.setPosition(improveInfo.getPosition());
        userCompany.setIntroduction(improveInfo.getIntroduction());
        userCompany.setScale(improveInfo.getScale());
        userCompany.setIntroductionPortrait(improveInfo.getIntroductionPortrait());
        userCompany.setContactPeple(improveInfo.getContactPeple());
        userCompany.setContactInfo(improveInfo.getContactInfon());
        userCompany.setCertificate(improveInfo.getCertificate());
        userCompany.setEstablishmentTime(improveInfo.getEstablishmentTime());
        userCompany.setUpdateBy(Constant.SYSTEM_NAME);
        userCompany.setUpdateTime(new Date());

        //修改学生家长明细
        return userCompanyDao.updateByPrimaryKeySelective(userCompany) == 1;
    }


}
