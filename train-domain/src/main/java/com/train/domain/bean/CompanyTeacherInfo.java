package com.train.domain.bean;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/3 17:25
 * Description: ${DESCRIPTION}
 */
public class CompanyTeacherInfo {

    private  String nickName;	//教师名称
    private String portrait;	//头像图片地址
    private Integer subject;	//教授科目
    private Integer teachingAge;//	教龄
    private String position;	//位置	需要分割符，待定
    private String introduction;//	简介
    private String freeVideo;	//试听视频地址

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
}
