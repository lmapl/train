package com.train.web.dao;

import java.io.Serializable;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/29 19:25
 * Description: ${DESCRIPTION}
 */
public class IdentityRequest implements Serializable{

    private String autograph;	// 登录保持签名 需要用服务器端rsa公钥加密,

    private  Integer type;	//身份类型 学生家长=1    教师=2；    机构=3；

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
