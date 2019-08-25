package com.train.domain.bean;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/2 16:50
 * Description: ${DESCRIPTION}
 */
public class UserCompanyInfo {
    private  String nickName;	//昵称
    private String portrait;	//头像图片地址
    private Integer gender	;  //性别	1=男； 2=女
    private String birthdayYear;	//生日
    private String birthdayMonth;	//生日
    private String birthdayDay;	//生日


    private Integer subject;	//教授科目
    private Integer teachingAge;//	教龄
    private String position;	//位置	需要分割符，待定

    private BigDecimal lon; //经纬度：经度
    private BigDecimal lat; //经纬度：纬度
    private String introduction;//	简介
    private String freeVideo;	//试听视频地址


    private String scale;	//规模
    private Long establishmentTime;	//成立时间
    private List<ImageInfo> introductionPortraits;	//环境图片地址	多个图片以 ; 分割
    private String contactPeple	;//机构联系人
    private String contactInfon;//	机构联系方式
    private String certificate	;//机构资质证明图片地址



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

    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    public Integer getTeachingAge() {
        return teachingAge;
    }

    public void setTeachingAge(Integer teachingAge) {
        this.teachingAge = teachingAge;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getFreeVideo() {
        return freeVideo;
    }

    public void setFreeVideo(String freeVideo) {
        this.freeVideo = freeVideo;
    }


    public String getContactPeple() {
        return contactPeple;
    }

    public void setContactPeple(String contactPeple) {
        this.contactPeple = contactPeple;
    }

    public String getContactInfon() {
        return contactInfon;
    }

    public void setContactInfon(String contactInfon) {
        this.contactInfon = contactInfon;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
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

    public List<ImageInfo> getIntroductionPortraits() {
        return introductionPortraits;
    }

    public void setIntroductionPortraits(List<ImageInfo> introductionPortraits) {
        this.introductionPortraits = introductionPortraits;
    }

    public Long getEstablishmentTime() {
        return establishmentTime;
    }

    public void setEstablishmentTime(Long establishmentTime) {
        this.establishmentTime = establishmentTime;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public BigDecimal getLon() {
        return lon;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }
}
