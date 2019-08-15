package com.train.domain.entity;

import java.util.Date;

public class UserTeacher {
    /**
     * 用户id，user表的主键
     */
    private Integer id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像地址
     */
    private String portrait;

    /**
     * 科目id
     */
    private Integer subjectId;

    /**
     * 教龄
     */
    private Integer teachingAge;

    /**
     * 位置
     */
    private String position;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 试听视频地址
     */
    private String freeVideo;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人，默认系统
     */
    private String createBy;

    /**
     * 最后一次修改时间
     */
    private Date updateTime;

    /**
     * 最后一次修改人
     */
    private String updateBy;

    /**
     * 用户id，user表的主键
     * @return id 用户id，user表的主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 用户id，user表的主键
     * @param id 用户id，user表的主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 昵称
     * @return nick_name 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 昵称
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 头像地址
     * @return portrait 头像地址
     */
    public String getPortrait() {
        return portrait;
    }

    /**
     * 头像地址
     * @param portrait 头像地址
     */
    public void setPortrait(String portrait) {
        this.portrait = portrait == null ? null : portrait.trim();
    }

    /**
     * 科目id
     * @return subject_id 科目id
     */
    public Integer getSubjectId() {
        return subjectId;
    }

    /**
     * 科目id
     * @param subjectId 科目id
     */
    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * 教龄
     * @return teaching_age 教龄
     */
    public Integer getTeachingAge() {
        return teachingAge;
    }

    /**
     * 教龄
     * @param teachingAge 教龄
     */
    public void setTeachingAge(Integer teachingAge) {
        this.teachingAge = teachingAge;
    }

    /**
     * 位置
     * @return position 位置
     */
    public String getPosition() {
        return position;
    }

    /**
     * 位置
     * @param position 位置
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * 简介
     * @return introduction 简介
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 简介
     * @param introduction 简介
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    /**
     * 试听视频地址
     * @return free_video 试听视频地址
     */
    public String getFreeVideo() {
        return freeVideo;
    }

    /**
     * 试听视频地址
     * @param freeVideo 试听视频地址
     */
    public void setFreeVideo(String freeVideo) {
        this.freeVideo = freeVideo == null ? null : freeVideo.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 创建人，默认系统
     * @return create_by 创建人，默认系统
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 创建人，默认系统
     * @param createBy 创建人，默认系统
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 最后一次修改时间
     * @return update_time 最后一次修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 最后一次修改时间
     * @param updateTime 最后一次修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 最后一次修改人
     * @return update_by 最后一次修改人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 最后一次修改人
     * @param updateBy 最后一次修改人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nickName=").append(nickName);
        sb.append(", portrait=").append(portrait);
        sb.append(", subjectId=").append(subjectId);
        sb.append(", teachingAge=").append(teachingAge);
        sb.append(", position=").append(position);
        sb.append(", introduction=").append(introduction);
        sb.append(", freeVideo=").append(freeVideo);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append("]");
        return sb.toString();
    }
}