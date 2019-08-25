package com.train.domain.entity;

import java.math.BigDecimal;
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
    private String scale;

    /**
     * 成立时间
     */
    private Date establishmentTime;

    /**
     * 位置
     */
    private String position;

    /**
     * 经纬度：经度
     */
    private BigDecimal lon;

    /**
     * 经纬度：纬度
     */
    private BigDecimal lat;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 环境图片地址
     */
    private String introductionPortraitIds;

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
    public String getScale() {
        return scale;
    }

    /**
     * 规模
     * @param scale 规模
     */
    public void setScale(String scale) {
        this.scale = scale == null ? null : scale.trim();
    }

    /**
     * 成立时间
     * @return establishment_time 成立时间
     */
    public Date getEstablishmentTime() {
        return establishmentTime;
    }

    /**
     * 成立时间
     * @param establishmentTime 成立时间
     */
    public void setEstablishmentTime(Date establishmentTime) {
        this.establishmentTime = establishmentTime;
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
     * 经纬度：经度
     * @return lon 经纬度：经度
     */
    public BigDecimal getLon() {
        return lon;
    }

    /**
     * 经纬度：经度
     * @param lon 经纬度：经度
     */
    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    /**
     * 经纬度：纬度
     * @return lat 经纬度：纬度
     */
    public BigDecimal getLat() {
        return lat;
    }

    /**
     * 经纬度：纬度
     * @param lat 经纬度：纬度
     */
    public void setLat(BigDecimal lat) {
        this.lat = lat;
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
     * @return introduction_portrait_ids 环境图片地址
     */
    public String getIntroductionPortraitIds() {
        return introductionPortraitIds;
    }

    /**
     * 环境图片地址
     * @param introductionPortraitIds 环境图片地址
     */
    public void setIntroductionPortraitIds(String introductionPortraitIds) {
        this.introductionPortraitIds = introductionPortraitIds == null ? null : introductionPortraitIds.trim();
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
        sb.append(", lon=").append(lon);
        sb.append(", lat=").append(lat);
        sb.append(", introduction=").append(introduction);
        sb.append(", introductionPortraitIds=").append(introductionPortraitIds);
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