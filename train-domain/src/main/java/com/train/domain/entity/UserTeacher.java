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
    private String nickname;

    /**
     * 头像地址
     */
    private String portrait;

    /**
     * 科目id
     */
    private Integer subjectid;

    /**
     * 教龄
     */
    private Integer teachingage;

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
    private String freevideo;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 创建人，默认系统
     */
    private String createby;

    /**
     * 最后一次修改时间
     */
    private Date updatetime;

    /**
     * 最后一次修改人
     */
    private String updateby;

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
     * @return nickName 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
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
     * @return subjectId 科目id
     */
    public Integer getSubjectid() {
        return subjectid;
    }

    /**
     * 科目id
     * @param subjectid 科目id
     */
    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    /**
     * 教龄
     * @return teachingAge 教龄
     */
    public Integer getTeachingage() {
        return teachingage;
    }

    /**
     * 教龄
     * @param teachingage 教龄
     */
    public void setTeachingage(Integer teachingage) {
        this.teachingage = teachingage;
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
     * @return freeVideo 试听视频地址
     */
    public String getFreevideo() {
        return freevideo;
    }

    /**
     * 试听视频地址
     * @param freevideo 试听视频地址
     */
    public void setFreevideo(String freevideo) {
        this.freevideo = freevideo == null ? null : freevideo.trim();
    }

    /**
     * 创建时间
     * @return createTime 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 创建时间
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 创建人，默认系统
     * @return createBy 创建人，默认系统
     */
    public String getCreateby() {
        return createby;
    }

    /**
     * 创建人，默认系统
     * @param createby 创建人，默认系统
     */
    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }

    /**
     * 最后一次修改时间
     * @return updateTime 最后一次修改时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 最后一次修改时间
     * @param updatetime 最后一次修改时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 最后一次修改人
     * @return updateBy 最后一次修改人
     */
    public String getUpdateby() {
        return updateby;
    }

    /**
     * 最后一次修改人
     * @param updateby 最后一次修改人
     */
    public void setUpdateby(String updateby) {
        this.updateby = updateby == null ? null : updateby.trim();
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
        sb.append(", nickname=").append(nickname);
        sb.append(", portrait=").append(portrait);
        sb.append(", subjectid=").append(subjectid);
        sb.append(", teachingage=").append(teachingage);
        sb.append(", position=").append(position);
        sb.append(", introduction=").append(introduction);
        sb.append(", freevideo=").append(freevideo);
        sb.append(", createtime=").append(createtime);
        sb.append(", createby=").append(createby);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", updateby=").append(updateby);
        sb.append("]");
        return sb.toString();
    }
}