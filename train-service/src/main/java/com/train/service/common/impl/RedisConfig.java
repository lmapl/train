package com.train.service.common.impl;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/29 13:44
 * Description: ${DESCRIPTION}
 */
public class RedisConfig {
    private int maxWaitMillis;
    private int maxTotal;
    private int minIdle;
    private int maxIdle;
    private int timeOut;

    public RedisConfig(int maxWaitMillis, int maxTotal, int minIdle, int maxIdle, int timeOut) {
        this.maxWaitMillis = maxWaitMillis;
        this.maxTotal = maxTotal;
        this.minIdle = minIdle;
        this.maxIdle = maxIdle;
        this.timeOut = timeOut;
    }

    public int getMaxWaitMillis() {
        return this.maxWaitMillis;
    }

    public void setMaxWaitMillis(int maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public int getMaxTotal() {
        return this.maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMinIdle() {
        return this.minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getMaxIdle() {
        return this.maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getTimeOut() {
        return this.timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }
}
