package com.train.domain.entity;

import java.util.Date;

public class UserCompany {
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
     * 规模
     */
    private Integer scale;

    /**
     * 成立时间
     */
    private String establishmentTime;

    /**
     * 位置
     */
    private String position;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 环境图片地址
     */
    private String introductionportrait;

    /**
     * 机构联系人
     */
    private String contactpeple;

    /**
     * 机构联系方式
     */
    private String contactinfon;

    /**
     * 机构资质证明图片地址
     */
    private String certificate;

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
     * 规模
     * @return scale 规模
     */
    public Integer getScale() {
        return scale;
    }

    /**
     * 规模
     * @param scale 规模
     */
    public void setScale(Integer scale) {
        this.scale = scale;
    }

    /**
     * 成立时间
     * @return establishment_time 成立时间
     */
    public String getEstablishmentTime() {
        return establishmentTime;
    }

    /**
     * 成立时间
     * @param establishmentTime 成立时间
     */
    public void setEstablishmentTime(String establishmentTime) {
        this.establishmentTime = establishmentTime == null ? null : establishmentTime.trim();
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
     * 环境图片地址
     * @return introductionPortrait 环境图片地址
     */
    public String getIntroductionportrait() {
        return introductionportrait;
    }

    /**
     * 环境图片地址
     * @param introductionportrait 环境图片地址
     */
    public void setIntroductionportrait(String introductionportrait) {
        this.introductionportrait = introductionportrait == null ? null : introductionportrait.trim();
    }

    /**
     * 机构联系人
     * @return contactPeple 机构联系人
     */
    public String getContactpeple() {
        return contactpeple;
    }

    /**
     * 机构联系人
     * @param contactpeple 机构联系人
     */
    public void setContactpeple(String contactpeple) {
        this.contactpeple = contactpeple == null ? null : contactpeple.trim();
    }

    /**
     * 机构联系方式
     * @return contactInfon 机构联系方式
     */
    public String getContactinfon() {
        return contactinfon;
    }

    /**
     * 机构联系方式
     * @param contactinfon 机构联系方式
     */
    public void setContactinfon(String contactinfon) {
        this.contactinfon = contactinfon == null ? null : contactinfon.trim();
    }

    /**
     * 机构资质证明图片地址
     * @return certificate 机构资质证明图片地址
     */
    public String getCertificate() {
        return certificate;
    }

    /**
     * 机构资质证明图片地址
     * @param certificate 机构资质证明图片地址
     */
    public void setCertificate(String certificate) {
        this.certificate = certificate == null ? null : certificate.trim();
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
        sb.append(", scale=").append(scale);
        sb.append(", establishmentTime=").append(establishmentTime);
        sb.append(", position=").append(position);
        sb.append(", introduction=").append(introduction);
        sb.append(", introductionportrait=").append(introductionportrait);
        sb.append(", contactpeple=").append(contactpeple);
        sb.append(", contactinfon=").append(contactinfon);
        sb.append(", certificate=").append(certificate);
        sb.append(", createtime=").append(createtime);
        sb.append(", createby=").append(createby);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", updateby=").append(updateby);
        sb.append("]");
        return sb.toString();
    }
}