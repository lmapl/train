package com.train.redis;

import java.security.InvalidParameterException;

/**
 * redis存储key结构
 * @author nian zecong
 * @version 1.0 2018/6/14
 */
public class RedisKey {

    /**
     * redis存储key
     */
    private String key;

    /**
     * redis存储过期时间
     */
    private int expireSeconds;

    /**
     * redis重建锁的key
     */
    private String rebuildLockKey;

    /**
     * redis重建锁的有效期,默认30s
     */
    private int rebuildLockKeySeconds = 30;

    /**
     * 刷新锁
     */
    private String refreshLockKey;

    /**
     * 是否hash形式存储
     */
    private boolean isHashKey = false;

    /**
     * hash的field
     */
    private String field;

    public RedisKey(String key, int expireSeconds){
        this.key = key;
        this.expireSeconds = expireSeconds;
        this.rebuildLockKey = key + "_L";
        this.refreshLockKey = key + "_R";
    }

    public RedisKey(String key, int expireSeconds, int rebuildLockKeySeconds){
        if(rebuildLockKeySeconds > expireSeconds){
            throw new InvalidParameterException("重构锁时长应小于等于缓存时长");
        }
        this.key = key;
        this.expireSeconds = expireSeconds;
        this.rebuildLockKey = key + "_L";
        this.refreshLockKey = key + "_R";
        this.rebuildLockKeySeconds = rebuildLockKeySeconds;
    }

    public RedisKey hasField(String field){
        this.isHashKey = true;
        this.field = field;
        this.rebuildLockKey = key + "_L_" + field;
        this.refreshLockKey = key + "_R_" + field;
        return this;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public String getRebuildLockKey() {
        return rebuildLockKey;
    }

    public void setRebuildLockKey(String rebuildLockKey) {
        this.rebuildLockKey = rebuildLockKey;
    }

    public int getRebuildLockKeySeconds() {
        return rebuildLockKeySeconds;
    }

    public void setRebuildLockKeySeconds(int rebuildLockKeySeconds) {
        this.rebuildLockKeySeconds = rebuildLockKeySeconds;
    }

    public String getRefreshLockKey() {
        return refreshLockKey;
    }

    public void setRefreshLockKey(String refreshLockKey) {
        this.refreshLockKey = refreshLockKey;
    }

    public boolean isHashKey() {
        return isHashKey;
    }

    public void setHashKey(boolean hashKey) {
        isHashKey = hashKey;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
