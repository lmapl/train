package com.train.domain.bean;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/2 16:50
 * Description: ${DESCRIPTION}
 */
public class UserStuParentInfo {
    private  String nickName;	//昵称
    private String portrait;	//头像图片地址
    private Integer gender	;  //性别	1=男； 2=女
    private String birthdayYear;	//生日
    private String birthdayMonth;	//生日
    private String birthdayDay;	//生日


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getBirthdayYear() {
        return birthdayYear;
    }

    public void setBirthdayYear(String birthdayYear) {
        this.birthdayYear = birthdayYear;
    }

    public String getBirthdayMonth() {
        return birthdayMonth;
    }

    public void setBirthdayMonth(String birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
    }

    public String getBirthdayDay() {
        return birthdayDay;
    }

    public void setBirthdayDay(String birthdayDay) {
        this.birthdayDay = birthdayDay;
    }


}
