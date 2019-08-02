package com.train.service;


import com.train.redis.RedisKey;
import com.train.utils.Constant;

/**
 * 彩蛋缓存
 */
public class ConstantRedis {

    private static final String PREFIX = "train:";

    public static RedisKey REDIS_INCR_NUM(String day) {
        return new RedisKey(PREFIX + "incr:number:" + day, Constant.DAY_SECONDS);
    }


    public static RedisKey SERVER_TOKEN(String type, String uuid) {
        return new RedisKey(PREFIX + "token:" + type + ":" + uuid, 60000);
    }

    public static RedisKey MOBILE_CODE(String mobile) {
        return new RedisKey(PREFIX + "mobile:code:" + mobile, Constant.MINUTES_5_SECONDS*1000);
    }

    public static RedisKey MOBILE_CODE_FREQUENCY_LIMIT(String mobile) {
        return new RedisKey(PREFIX + "mobile:frequency:" + mobile, Constant.MINUTES_SECONDS);
    }

    public static RedisKey MOBILE_CODE_TIMES_LIMIT(String day) {
        return new RedisKey(PREFIX + "mobile:times:" + day, Constant.DAY_SECONDS);
    }

    public static RedisKey LOGIN_SESSION() {
        return new RedisKey(PREFIX + "login:session" , -1);
    }

}
