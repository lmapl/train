package com.train.web.dao;

import java.io.Serializable;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/29 19:25
 * Description: ${DESCRIPTION}
 */
public class BindRequest extends BaseRequest implements Serializable{

    private  String mobile;	 //用户名	需要用服务器端rsa公钥加密（手机号码）
    private String mobileVerifyCode;	//手机验证码	需要用服务器端rsa公钥加密（手机验证码）

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobileVerifyCode() {
        return mobileVerifyCode;
    }

    public void setMobileVerifyCode(String mobileVerifyCode) {
        this.mobileVerifyCode = mobileVerifyCode;
    }
}
