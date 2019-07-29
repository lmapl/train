package com.train.service.common;

/**
 * @author Nian Zecong
 * @version 1.0 2018/7/18
 */

public interface RedisService {

    String get(String key) ;

    String set(String key, String value) ;
}
