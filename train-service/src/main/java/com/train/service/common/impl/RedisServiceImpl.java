package com.train.service.common.impl;

import com.train.service.common.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/29 12:02
 * Description: ${DESCRIPTION}
 */
public class RedisServiceImpl implements RedisService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    //private JedisSentinelPool jedisSentinelPool;
    private Jedis jedis;

    private Set<String> getHost(String sentinelHost) {
        Set<String> hosts = new HashSet<>();
        Collections.addAll(hosts, sentinelHost.split(";"));
        return hosts;
    }

    public RedisServiceImpl( String sentinelHost, String masterName, int maxWaitMillis, int maxTotal, int minIdle, int maxIdle, int timeOut) throws Exception {
       /* RedisConfig config = new RedisConfig(maxWaitMillis, maxTotal, minIdle, maxIdle, timeOut);
        this.jedisSentinelPool = JedisFactory.getJedisPoolRetry(this.getHost(sentinelHost), masterName, config, 5);*/
        this.jedis = new Jedis("39.97.167.39",6379);
    }

    /*public synchronized Jedis getJedis() throws JedisException {
        return this.jedisSentinelPool.getResource();
    }*/

    @Override
    public String get(String key) {
        try {
            return jedis.get(key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String set(String key, String value) {
        try {
            return jedis.set(key, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
