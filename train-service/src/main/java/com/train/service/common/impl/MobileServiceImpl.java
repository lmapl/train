package com.train.service.common.impl;

import com.train.Exception.AuthException;
import com.train.domain.enums.TokenTypeEnum;
import com.train.redis.RedisKey;
import com.train.service.ConstantRedis;
import com.train.service.common.MobileService;
import com.train.service.common.RedisService;
import com.train.service.common.TokenService;
import com.train.utils.Constant;
import com.train.utils.DateUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/29 16:23
 * Description: ${DESCRIPTION}
 */
@Service
public class MobileServiceImpl implements MobileService {

    @Resource
    private TokenService tokenService;

    @Resource
    private RedisService redisService;

    @Value("${number.alphabet}")
    String alphabet;

    @Override
    public void getMobileVerifyCode(String mobile,String uuid, String token) {

        boolean verify = tokenService.verifyNotLoginToken(TokenTypeEnum.MOBILE_CODE.getKey(),token);
        if(!verify){
            throw new AuthException("token鉴权失败");
        }

        //限制一分钟只可以发送一次
        //加锁
        RedisKey limitKey = ConstantRedis.MOBILE_CODE_FREQUENCY_LIMIT(mobile);
        if(redisService.setnx(limitKey.getKey(),"1",limitKey.getExpireSeconds()) != 1L){
            return;
        }

        //限制一天可以收到的短信上限10次
        String day = DateUtil.format(new Date(),DateUtil.YMD_FORMAT);
        RedisKey redisKey =  ConstantRedis.MOBILE_CODE_TIMES_LIMIT(day);
        Long times = redisService.hincrBy(redisKey.getKey(),mobile,1);
        redisService.expire(redisKey.getKey(),redisKey.getExpireSeconds());
        if(times > 10){
            return;
        }

        String code = RandomStringUtils.random(6,alphabet);
        Integer expire = Constant.MINUTES_5_SECONDS;

        RedisKey mobileCodeKey = ConstantRedis.MOBILE_CODE(mobile);
        redisService.setEx(mobileCodeKey.getKey(),code,expire);

        // TODO: 2019/7/29 调用短信发送平台，完成发送
    }

    @Override
    public boolean verifyCode(String mobile, String code) {
        RedisKey mobileCodeKey = ConstantRedis.MOBILE_CODE(mobile);
        String val = redisService.get(mobileCodeKey.getKey());
        if(val != null && val.equals(code)){
            redisService.del(mobileCodeKey.getKey());
            return true;
        }
        return false;
    }
}
