package com.train.domain.bean;

import java.io.Serializable;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/29 19:25
 * Description: ${DESCRIPTION}
 */
public class LoginInfo implements Serializable{

    private Integer type;	//注册方式		手机号 = 1，微信 = 2

    private String autograph;	//设备唯一码		需要用服务器端rsa公钥加密,
    private String userName;	//用户名		需要用服务器端rsa公钥加密（手机号码）手机号码、微信名
    private String password;	//密码		需要用服务器端rsa公钥加密,（md5加密, 微信token等）
    private String mobileVerifyCode;	//手机验证码		需要用服务器端rsa公钥加密,（手机验证码）

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileVerifyCode() {
        return mobileVerifyCode;
    }

    public void setMobileVerifyCode(String mobileVerifyCode) {
        this.mobileVerifyCode = mobileVerifyCode;
    }



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
