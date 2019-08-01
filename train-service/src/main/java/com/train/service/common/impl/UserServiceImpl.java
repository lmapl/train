package com.train.service.common.impl;

import com.train.Exception.AuthException;
import com.train.Exception.InternalServerException;
import com.train.dao.UserDao;
import com.train.domain.bean.LoginInfo;
import com.train.domain.bean.RegisterInfo;
import com.train.domain.entity.User;
import com.train.domain.enums.TokenTypeEnum;
import com.train.domain.enums.UserStatusEnum;
import com.train.domain.enums.UserTypeEnum;
import com.train.redis.RedisKey;
import com.train.service.ConstantRedis;
import com.train.service.common.*;
import com.train.utils.DateUtil;
import org.springframework.stereotype.Service;
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
            String password = rsaService.decryptByPrivateKey(loginInfo.getUserName());
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
}
