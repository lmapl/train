package com.train.domain.entity;

import java.util.Date;

public class User {
    /**
     * 用户id，全局唯一
     */
    private Integer id;

    /**
     * 
     */
    private Integer platform;

    /**
     * 设备唯一码
     */
    private String deviceUuid;

    /**
     * 0 待定，1学生家长，2老师、3机构
     */
    private Integer userType;

    /**
     * 1邮箱，2微信，3手机号码，4qq
     */
    private Integer registerType;

    /**
     * 注册凭证：手机号码/微信号，邮箱，qq号
     */
    private String registerCertificate;

    /**
     * 密码：邮箱注册，手机注册时密码要md5加密
     */
    private String password;

    /**
     * 状态：
     */
    private Integer status;

    /**
     * 合并账号后，新生成的用户保存之前的两个账号的id
     */
    private String mergeParentIds;

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
     * 用户id，全局唯一
     * @return id 用户id，全局唯一
     */
    public Integer getId() {
        return id;
    }

    /**
     * 用户id，全局唯一
     * @param id 用户id，全局唯一
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return platform 
     */
    public Integer getPlatform() {
        return platform;
    }

    /**
     * 
     * @param platform 
     */
    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    /**
     * 设备唯一码
     * @return device_uuid 设备唯一码
     */
    public String getDeviceUuid() {
        return deviceUuid;
    }

    /**
     * 设备唯一码
     * @param deviceUuid 设备唯一码
     */
    public void setDeviceUuid(String deviceUuid) {
        this.deviceUuid = deviceUuid == null ? null : deviceUuid.trim();
    }

    /**
     * 0 待定，1学生家长，2老师、3机构
     * @return user_type 0 待定，1学生家长，2老师、3机构
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 0 待定，1学生家长，2老师、3机构
     * @param userType 0 待定，1学生家长，2老师、3机构
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 1邮箱，2微信，3手机号码，4qq
     * @return register_type 1邮箱，2微信，3手机号码，4qq
     */
    public Integer getRegisterType() {
        return registerType;
    }

    /**
     * 1邮箱，2微信，3手机号码，4qq
     * @param registerType 1邮箱，2微信，3手机号码，4qq
     */
    public void setRegisterType(Integer registerType) {
        this.registerType = registerType;
    }

    /**
     * 注册凭证：手机号码/微信号，邮箱，qq号
     * @return register_certificate 注册凭证：手机号码/微信号，邮箱，qq号
     */
    public String getRegisterCertificate() {
        return registerCertificate;
    }

    /**
     * 注册凭证：手机号码/微信号，邮箱，qq号
     * @param registerCertificate 注册凭证：手机号码/微信号，邮箱，qq号
     */
    public void setRegisterCertificate(String registerCertificate) {
        this.registerCertificate = registerCertificate == null ? null : registerCertificate.trim();
    }

    /**
     * 密码：邮箱注册，手机注册时密码要md5加密
     * @return password 密码：邮箱注册，手机注册时密码要md5加密
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码：邮箱注册，手机注册时密码要md5加密
     * @param password 密码：邮箱注册，手机注册时密码要md5加密
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 状态：
     * @return status 状态：
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态：
     * @param status 状态：
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 合并账号后，新生成的用户保存之前的两个账号的id
     * @return merge_parent_ids 合并账号后，新生成的用户保存之前的两个账号的id
     */
    public String getMergeParentIds() {
        return mergeParentIds;
    }

    /**
     * 合并账号后，新生成的用户保存之前的两个账号的id
     * @param mergeParentIds 合并账号后，新生成的用户保存之前的两个账号的id
     */
    public void setMergeParentIds(String mergeParentIds) {
        this.mergeParentIds = mergeParentIds == null ? null : mergeParentIds.trim();
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
        sb.append(", platform=").append(platform);
        sb.append(", deviceUuid=").append(deviceUuid);
        sb.append(", userType=").append(userType);
        sb.append(", registerType=").append(registerType);
        sb.append(", registerCertificate=").append(registerCertificate);
        sb.append(", password=").append(password);
        sb.append(", status=").append(status);
        sb.append(", mergeParentIds=").append(mergeParentIds);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append("]");
        return sb.toString();
    }
}