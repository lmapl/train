package com.train.service.common;

/**
 * @author Nian Zecong
 * @version 1.0 2018/7/18
 */

public interface RedisService {

    String get(String key) ;

    String set(String key, String value) ;

    void setEx(String key, String value, Integer expire);

    String hget(String key, String field) ;

    Long hset(String key, String field, String value) ;

    Long setnx(String key, String value, int expireTime);

    Integer ttl(String key);

    Long hincrBy(String key, String field, long value);

    Long del(String key) ;
}
