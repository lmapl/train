package com.train.web.dao;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/2 16:43
 * Description: ${DESCRIPTION}
 */
public class BaseRequest {
    private String autograph;	// 登录保持签名 需要用服务器端rsa公钥加密,

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }
}
