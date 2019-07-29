package com.train.service.common.impl;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSentinelPool;

import java.util.Set;

public class JedisFactory {
    public JedisFactory() {
    }

    public static JedisCluster getJedisCluster(Set<HostAndPort> hostAndPorts, RedisConfig redisConfig) {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxWaitMillis((long)redisConfig.getMaxWaitMillis());
        config.setMaxTotal(redisConfig.getMaxTotal());
        config.setMinIdle(redisConfig.getMinIdle());
        config.setMaxIdle(redisConfig.getMaxIdle());
        return new JedisCluster(hostAndPorts, redisConfig.getTimeOut(), config);
    }

    public static JedisSentinelPool getJedisPool(Set<String> sentinelStrSet, String masterName, RedisConfig redisConfig) {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxWaitMillis((long)redisConfig.getMaxWaitMillis());
        config.setMaxTotal(redisConfig.getMaxTotal());
        config.setMinIdle(redisConfig.getMinIdle());
        config.setMaxIdle(redisConfig.getMaxIdle());
        return new JedisSentinelPool(masterName, sentinelStrSet, config, redisConfig.getTimeOut());
    }

    public static JedisSentinelPool getJedisPoolRetry(Set<String> sentinelStrSet, String masterName, RedisConfig redisConfig, int retryTimes) throws Exception {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxWaitMillis((long)redisConfig.getMaxWaitMillis());
        config.setMaxTotal(redisConfig.getMaxTotal());
        config.setMinIdle(redisConfig.getMinIdle());
        config.setMaxIdle(redisConfig.getMaxIdle());

        JedisSentinelPool pool;
        try {
            pool = new JedisSentinelPool(masterName, sentinelStrSet, config, redisConfig.getTimeOut());
        } catch (Exception var9) {
            if (retryTimes == 1) {
                throw var9;
            }

            try {
                Thread.sleep(100L);
            } catch (InterruptedException var8) {
                ;
            }

            pool = getJedisPoolRetry(sentinelStrSet, masterName, redisConfig, retryTimes - 1);
        }

        return pool;
    }

    public static JedisPool getSingleJedisPoolRetry(HostAndPort hostAndPort, RedisConfig redisConfig, int retryTimes) throws Exception {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxWaitMillis((long)redisConfig.getMaxWaitMillis());
        config.setMaxTotal(redisConfig.getMaxTotal());
        config.setMinIdle(redisConfig.getMinIdle());
        config.setMaxIdle(redisConfig.getMaxIdle());
        config.setTestOnBorrow(true);
        config.setTestWhileIdle(true);

        JedisPool pool;
        try {
            pool = new JedisPool(config, hostAndPort.getHost(), hostAndPort.getPort(), redisConfig.getTimeOut());
        } catch (Exception var8) {
            if (retryTimes == 1) {
                throw var8;
            }

            try {
                Thread.sleep(100L);
            } catch (InterruptedException var7) {
                ;
            }

            pool = getSingleJedisPoolRetry(hostAndPort, redisConfig, retryTimes - 1);
        }

        return pool;
    }
}
