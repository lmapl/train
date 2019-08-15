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
    private String nickName;

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
    private String introductionPortrait;

    /**
     * 机构联系人
     */
    private String contactPeple;

    /**
     * 机构联系方式
     */
    private String contactInfo;

    /**
     * 机构资质证明图片地址
     */
    private String certificate;

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
     * @return nick_Name 昵称
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
     * @return introduction_portrait 环境图片地址
     */
    public String getIntroductionPortrait() {
        return introductionPortrait;
    }

    /**
     * 环境图片地址
     * @param introductionPortrait 环境图片地址
     */
    public void setIntroductionPortrait(String introductionPortrait) {
        this.introductionPortrait = introductionPortrait == null ? null : introductionPortrait.trim();
    }

    /**
     * 机构联系人
     * @return contact_peple 机构联系人
     */
    public String getContactPeple() {
        return contactPeple;
    }

    /**
     * 机构联系人
     * @param contactPeple 机构联系人
     */
    public void setContactPeple(String contactPeple) {
        this.contactPeple = contactPeple == null ? null : contactPeple.trim();
    }

    /**
     * 机构联系方式
     * @return contact_info 机构联系方式
     */
    public String getContactInfo() {
        return contactInfo;
    }

    /**
     * 机构联系方式
     * @param contactInfo 机构联系方式
     */
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo == null ? null : contactInfo.trim();
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
        sb.append(", scale=").append(scale);
        sb.append(", establishmentTime=").append(establishmentTime);
        sb.append(", position=").append(position);
        sb.append(", introduction=").append(introduction);
        sb.append(", introductionPortrait=").append(introductionPortrait);
        sb.append(", contactPeple=").append(contactPeple);
        sb.append(", contactInfo=").append(contactInfo);
        sb.append(", certificate=").append(certificate);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append("]");
        return sb.toString();
    }
}