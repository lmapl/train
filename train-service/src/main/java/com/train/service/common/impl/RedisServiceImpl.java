package com.train.service.common.impl;

import com.train.service.common.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.exceptions.JedisException;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/29 12:02
 * Description: ${DESCRIPTION}
 */
public class RedisServiceImpl implements RedisService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private Jedis jedis;

    private Set<String> getHost(String sentinelHost) {
        Set<String> hosts = new HashSet<>();
        Collections.addAll(hosts, sentinelHost.split(";"));
        return hosts;
    }

    private Pipeline pipeline() {
        try {
            return jedis.pipelined();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Object> submitAndReturn(Pipeline pipeline) throws JedisException {
        if (null != pipeline && null != this.jedis) {
            List var1;
            try {
                var1 = pipeline.syncAndReturnAll();
            } catch (JedisException var5) {
                throw var5;
            } finally {
                this.jedis.close();
            }

            return var1;
        } else {
            return null;
        }
    }



    public RedisServiceImpl( String sentinelHost, String masterName, int maxWaitMillis, int maxTotal, int minIdle, int maxIdle, int timeOut) throws Exception {
       /* RedisConfig config = new RedisConfig(maxWaitMillis, maxTotal, minIdle, maxIdle, timeOut);
        this.jedisSentinelPool = JedisFactory.getJedisPoolRetry(this.getHost(sentinelHost), masterName, config, 5);*/
        this.jedis = new Jedis("39.97.167.39",6379);
    }

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

    @Override
    public void setEx(String key, String value, Integer expire) {

        try {
            jedis.setex(key,expire,value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String hget(String key, String field) {
        try {
            return jedis.hget(key, field);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long hset(String key, String field, String value) {
        try {
            return jedis.hset(key, field, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long setnx(String key, String value, int expireTime) {
        String result;
        try {
            SetParams params = new SetParams();
            params.ex(expireTime);
            params.nx();
            result = jedis.set(key, value, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result == null ? 0L : 1L;
    }

    @Override
    public Integer ttl(String key) {
        try {
            return jedis.ttl(key).intValue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Long hincrBy(String key, String field, long value) {
        try {
            return jedis.hincrBy(key, field, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long del(String key) {
        try {
            return jedis.del(key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long incrBy(String key, long value) {
        try {
            return jedis.incrBy(key,value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long expire(String key, int expireSeconds) {
        try {
            return jedis.expire(key, expireSeconds);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
