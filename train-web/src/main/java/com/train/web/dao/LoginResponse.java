package com.train.web.dao;

import java.io.Serializable;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/29 19:25
 * Description: ${DESCRIPTION}
 */
public class LoginResponse implements Serializable{

    private  String autograph;	//登录后凭证	服务端RSA加密（token|随机数|用户名|平台|时间|rediSsessionId|随机数）  客户端需解密该凭证，获得token和sessionid，用以以后的登录保持签名
    private Integer userType;	//用户身份	0=待定； 学生家长=1 教师=2； 机构=3；
    private Integer educateLevel;	//学历等级	1 =小学； 2=中学； 3=高中； 4=大学； 5=研究生
    private Integer grade;	//年级	1=1年级； 2=2年级； 3=3年级 ....依次类推

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getEducateLevel() {
        return educateLevel;
    }

    public void setEducateLevel(Integer educateLevel) {
        this.educateLevel = educateLevel;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
