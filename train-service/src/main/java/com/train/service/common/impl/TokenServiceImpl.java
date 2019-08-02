package com.train.service.common.impl;

import com.train.Exception.InvalidParamException;
import com.train.domain.bean.UserSessionInfo;
import com.train.redis.RedisKey;
import com.train.service.Constant;
import com.train.service.ConstantRedis;
import com.train.service.common.RedisService;
import com.train.service.common.RsaService;
import com.train.service.common.TokenService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/29 11:50
 * Description: ${DESCRIPTION}
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Resource
    private RsaService rsaService;

    @Value("${common.alphabet}")
    String alphabet;

    @Resource
    private RedisService redisService;

    /**
     * 程序需保障同一时间，一个uuid只可以有一个token
     * @param uuid uuid
     * @return token
     */
    @Override
    public String getServerToken(String type ,String uuid) {
        uuid = rsaService.decryptByPrivateKey(uuid);
        if(StringUtils.isEmpty(uuid)){
            throw new InvalidParamException("参数错误");
        }
        RedisKey redisKey = ConstantRedis.SERVER_TOKEN(type,uuid);
        String val = redisService.get(redisKey.getKey());
        if(StringUtils.isEmpty(val)){
            val = RandomStringUtils.random(8,alphabet);
            redisService.setEx(redisKey.getKey(),val,redisKey.getExpireSeconds());
        }
        return rsaService.encryptByPublicKey(val);
    }

    @Override
    public boolean verifyNotLoginToken(Integer type ,String encryptAuth) {
        String auth = rsaService.decryptByPrivateKey(encryptAuth);
        if(StringUtils.isEmpty(auth)){
            return false;
        }

        String[] arrs = auth.split("\\|");

        //平台|uuid|服务器凭证|随机数|时间|随机数
        if(arrs.length != 6){
            return false;
        }
        String token = arrs[2];
        String uuid = arrs[1];

        if(StringUtils.isEmpty(token) || StringUtils.isEmpty(uuid)){
            return false;
        }

        RedisKey redisKey = ConstantRedis.SERVER_TOKEN(type+"",uuid);
        String val = redisService.get(redisKey.getKey());
        redisService.del(redisKey.getKey());
        return  val != null && token.equals(val);
    }

    @Override
    public String getLoginToken(Integer userId,String registerCertificate, Integer platform, String uuid, String sessionId) {
        //uid|uuid|随机数|用户名|平台|时间|rediSsessionId|随机数
        String  random1 = RandomStringUtils.random(6,alphabet);
        String  random2 = RandomStringUtils.random(3,alphabet);
        Long time = System.currentTimeMillis()+ Constant.DAY_SECONDS * 1000;
        StringBuilder builder =  new StringBuilder();
        builder.append(userId).append("|")
                .append(uuid).append("|")
                .append(random1).append("|")
                .append(registerCertificate).append("|")
                .append(platform).append("|")
                .append(time).append("|")
                .append(sessionId).append("|")
                .append(random2);
        String token = builder.toString();

        // TODO: 2019/7/31 需要一个定时任务，随时清理无效（有效时间到了的）
        RedisKey redisKey = ConstantRedis.LOGIN_SESSION();
        redisService.hset(redisKey.getKey(),sessionId,token);
        return rsaService.encryptByPublicKey(token);
    }

    @Override
    public UserSessionInfo verifyLoginToken(String encryptAuth) {
        //平台|uid|uuid|随机数|用户名|时间|rediSsessionId|随机数
        String auth = rsaService.decryptByPrivateKey(encryptAuth);
        if(StringUtils.isEmpty(auth)){
            return null;
        }

        String[] arrs = auth.split("\\|");

        //平台|uuid|服务器凭证|随机数|时间|随机数
        if(arrs.length != 8){
            return null;
        }
        String uid = arrs[1];
        String ssessionId = arrs[6];

        RedisKey redisKey = ConstantRedis.LOGIN_SESSION();
        String val = redisService.hget(redisKey.getKey(),ssessionId);
        if(StringUtils.isEmpty(val)){
            return null;
        }

        String[] loginArrs = val.split("\\|");
        if(loginArrs.length != 8){
            return null;
        }
        //uid|uuid|随机数|用户名|平台|时间|rediSsessionId|随机数
        String expireTime = loginArrs[5];
        String uidLogin = loginArrs[0];
        String ssessionIdLogin = loginArrs[6];
        Long time = System.currentTimeMillis();
        if(Long.valueOf(expireTime) < time){
            return null;
        }

        if(!uidLogin.equals(uid) || !ssessionIdLogin.equals(ssessionId)){
            return null;
        }

        // TODO: 2019/8/2 判断过期时间是否比当前时间大半天，如果不是，那么延长过期时间到1天

        UserSessionInfo userSessionInfo = new UserSessionInfo();
        userSessionInfo.setSessionId(ssessionId);
        userSessionInfo.setUserId(Integer.valueOf(uid));
        return userSessionInfo;
    }

    @Override
    public Boolean loginOut(String encryptAuth) {
        if(StringUtils.isEmpty(encryptAuth)){
            return false;
        }
        UserSessionInfo userSessionInfo = verifyLoginToken(encryptAuth);
        if(userSessionInfo == null || StringUtils.isEmpty(userSessionInfo.getSessionId())){
            return false;
        }
        RedisKey redisKey = ConstantRedis.LOGIN_SESSION();
        redisService.hdel(redisKey.getKey(),userSessionInfo.getSessionId());
        return true;
    }
}
