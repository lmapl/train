package com.train.service;


import com.train.redis.RedisKey;

/**
 * 彩蛋缓存
 */
public class ConstantRedis {

    private static final String PREFIX = "train:";


    public static RedisKey SERVER_TOKEN(String type, String uuid) {
        return new RedisKey(PREFIX + "token:" + type + ":" + uuid, 60);
    }

    public static RedisKey MOBILE_CODE(String mobile) {
        return new RedisKey(PREFIX + "mobile:code:" + mobile, Constant.MINUTES_5_SECONDS);
    }

    public static RedisKey MOBILE_CODE_FREQUENCY_LIMIT(String mobile) {
        return new RedisKey(PREFIX + "mobile:frequency:" + mobile, Constant.MINUTES_SECONDS);
    }

    public static RedisKey MOBILE_CODE_TIMES_LIMIT(String day) {
        return new RedisKey(PREFIX + "mobile:times:" + day, Constant.DAY_SECONDS);
    }

}
