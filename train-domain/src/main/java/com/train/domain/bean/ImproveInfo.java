package com.train.domain.bean;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/2 16:50
 * Description: ${DESCRIPTION}
 */
public class ImproveInfo {
    private String autograph;	//签名		需要用服务器端rsa公钥加密,

    private  String nickName;	//昵称
    private String portrait;	//头像图片地址
    private Integer gender	;  //性别	1=男； 2=女
    private String birthday;	//生日

    private Integer subject;	//教授科目
    private Integer teachingAge;//	教龄
    private String position;	//位置	需要分割符，待定
    private String introduction;//	简介
    private String freeVideo;	//试听视频地址



    private Integer scale;	//规模
    private Integer curriculum;	//成立时间
    private String introductionPortrait;	//环境图片地址	多个图片以 ; 分割
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
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

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public Integer getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Integer curriculum) {
        this.curriculum = curriculum;
    }

    public String getIntroductionPortrait() {
        return introductionPortrait;
    }

    public void setIntroductionPortrait(String introductionPortrait) {
        this.introductionPortrait = introductionPortrait;
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
}
