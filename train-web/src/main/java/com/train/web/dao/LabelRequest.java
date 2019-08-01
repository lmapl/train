package com.train.web.dao;

import java.io.Serializable;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/29 19:25
 * Description: ${DESCRIPTION}
 */
public class LabelRequest implements Serializable{

    private String autograph;	// 登录保持签名 需要用服务器端rsa公钥加密,

    private  Integer educateLevel;	//学历等级	1 =小学； 2=中学； 3=高中； 4=大学； 5=研究生
    private Integer grade;	//年级	1=1年级； 2=2年级； 3=3年级 ....依次类推


    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
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
