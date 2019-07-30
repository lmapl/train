package com.train.service.common.impl;

import com.train.Exception.InvalidParamException;
import com.train.redis.RedisKey;
import com.train.service.ConstantRedis;
import com.train.service.common.RedisService;
import com.train.service.common.TokenService;
import com.train.utils.RSAUtils;
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


    @Value("${server.rsa.privatekey}")
    private String serverRsaPrivateKey;

    @Value("${client.rsa.publickey}")
    private String clientRsaPublicKey;

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
        uuid = RSAUtils.decryptByPrivateKey(uuid,serverRsaPrivateKey);
        if(StringUtils.isEmpty(uuid)){
            throw new InvalidParamException("参数错误");
        }
        RedisKey redisKey = ConstantRedis.SERVER_TOKEN(type,uuid);
        String val = redisService.get(redisKey.getKey());
        if(StringUtils.isEmpty(val)){
            val = RandomStringUtils.random(8,alphabet);
            redisService.setEx(redisKey.getKey(),val,redisKey.getExpireSeconds());
        }
        return RSAUtils.encryptByPublicKey(val, clientRsaPublicKey);
    }

    @Override
    public boolean verifyToken(String type ,String uuid,String encryptToken,String mobile) {
        uuid = RSAUtils.decryptByPrivateKey(uuid,serverRsaPrivateKey);
        if(StringUtils.isEmpty(uuid)){
            return false;
        }

        String token = RSAUtils.decryptByPrivateKey(encryptToken,serverRsaPrivateKey);
        if(StringUtils.isEmpty(token)){
            return false;
        }
        String[] arrs = token.split("\\|");
        if(!mobile.startsWith(arrs[2])){
            return false;
        }

        RedisKey redisKey = ConstantRedis.SERVER_TOKEN(type,uuid);
        String val = redisService.get(redisKey.getKey());
        redisService.del(redisKey.getKey());
        return arrs[1] != null && val != null && arrs[1].equals(val);
    }
}
