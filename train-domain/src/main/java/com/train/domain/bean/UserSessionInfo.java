package com.train.domain.bean;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/1 18:09
 * Description: ${DESCRIPTION}
 */
public class UserSessionInfo {

    private Integer userId;

    private String sessionId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
