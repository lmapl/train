package com.train.service.common.impl;

import com.train.Exception.AuthException;
import com.train.dao.UserDao;
import com.train.domain.bean.LoginInfo;
import com.train.domain.bean.RegisterInfo;
import com.train.domain.entity.User;
import com.train.domain.enums.UserStatusEnum;
import com.train.domain.enums.UserTypeEnum;
import com.train.service.common.MobileService;
import com.train.service.common.RsaService;
import com.train.service.common.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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
    private UserDao userDao;

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
    public boolean mobileLoginVerify(LoginInfo loginInfo) {
        if(loginInfo == null
                || loginInfo.getType() == null
                || loginInfo.getAutograph() == null
                || loginInfo.getUserName() == null
                || (loginInfo.getMobileVerifyCode() == null && loginInfo.getPassword() == null)){
            return false;
        }
        return false;
    }
}
