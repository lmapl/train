package com.train.web.dao;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/29 19:25
 * Description: ${DESCRIPTION}
 */
public class RegisterRequest implements Serializable{

    private Integer platform;	//平台		ios = 1 ,android = 2
    private String uuid;	//设备唯一码		需要用服务器端rsa公钥加密,
    private Integer type;	//注册方式		手机号 = 1，微信 = 2
    private String userName;	//用户名		手机号码、微信名
    private String password;	//密码		需要用服务器端rsa公钥加密,（md5加密, 微信token等）
    private String mobileVerifyCode;	//手机验证码		需要用服务器端rsa公钥加密,（手机验证码）


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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

    public static void main(String[] args){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setMobileVerifyCode("xxxx");
        registerRequest.setPassword("bbbb");
        registerRequest.setPlatform(1);
        registerRequest.setType(1);
        registerRequest.setUserName("aaa");
        registerRequest.setUuid("ddd");
        System.out.println(new Gson().toJson(registerRequest));
    }
}
