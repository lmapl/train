package com.train.domain.entity;

import java.util.Date;

public class User {
    /**
     * 用户id，全局唯一
     */
    private Integer id;

    /**
     * 设备唯一码
     */
    private String deviceuuid;

    /**
     * 1学生家长，2老师、3机构
     */
    private Integer usertype;

    /**
     * 1邮箱，2微信，3手机号码，4qq
     */
    private Integer registertype;

    /**
     * 注册凭证：手机号码/微信号，邮箱，qq号
     */
    private String registercertificate;

    /**
     * 密码：邮箱注册，手机注册时密码要md5加密
     */
    private String password;

    /**
     * 有效标识：默认有效，注销时，合并账号时改为无效，新账号为有效
     */
    private Integer valid;

    /**
     * 禁用标识：默认否，被举报审核后改为是
     */
    private Integer forbid;

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
     * 设备唯一码
     * @return deviceUuid 设备唯一码
     */
    public String getDeviceuuid() {
        return deviceuuid;
    }

    /**
     * 设备唯一码
     * @param deviceuuid 设备唯一码
     */
    public void setDeviceuuid(String deviceuuid) {
        this.deviceuuid = deviceuuid == null ? null : deviceuuid.trim();
    }

    /**
     * 1学生家长，2老师、3机构
     * @return userType 1学生家长，2老师、3机构
     */
    public Integer getUsertype() {
        return usertype;
    }

    /**
     * 1学生家长，2老师、3机构
     * @param usertype 1学生家长，2老师、3机构
     */
    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    /**
     * 1邮箱，2微信，3手机号码，4qq
     * @return registerType 1邮箱，2微信，3手机号码，4qq
     */
    public Integer getRegistertype() {
        return registertype;
    }

    /**
     * 1邮箱，2微信，3手机号码，4qq
     * @param registertype 1邮箱，2微信，3手机号码，4qq
     */
    public void setRegistertype(Integer registertype) {
        this.registertype = registertype;
    }

    /**
     * 注册凭证：手机号码/微信号，邮箱，qq号
     * @return registerCertificate 注册凭证：手机号码/微信号，邮箱，qq号
     */
    public String getRegistercertificate() {
        return registercertificate;
    }

    /**
     * 注册凭证：手机号码/微信号，邮箱，qq号
     * @param registercertificate 注册凭证：手机号码/微信号，邮箱，qq号
     */
    public void setRegistercertificate(String registercertificate) {
        this.registercertificate = registercertificate == null ? null : registercertificate.trim();
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
     * 有效标识：默认有效，注销时，合并账号时改为无效，新账号为有效
     * @return valid 有效标识：默认有效，注销时，合并账号时改为无效，新账号为有效
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * 有效标识：默认有效，注销时，合并账号时改为无效，新账号为有效
     * @param valid 有效标识：默认有效，注销时，合并账号时改为无效，新账号为有效
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }

    /**
     * 禁用标识：默认否，被举报审核后改为是
     * @return forbid 禁用标识：默认否，被举报审核后改为是
     */
    public Integer getForbid() {
        return forbid;
    }

    /**
     * 禁用标识：默认否，被举报审核后改为是
     * @param forbid 禁用标识：默认否，被举报审核后改为是
     */
    public void setForbid(Integer forbid) {
        this.forbid = forbid;
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
        sb.append(", deviceuuid=").append(deviceuuid);
        sb.append(", usertype=").append(usertype);
        sb.append(", registertype=").append(registertype);
        sb.append(", registercertificate=").append(registercertificate);
        sb.append(", password=").append(password);
        sb.append(", valid=").append(valid);
        sb.append(", forbid=").append(forbid);
        sb.append(", createtime=").append(createtime);
        sb.append(", createby=").append(createby);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", updateby=").append(updateby);
        sb.append("]");
        return sb.toString();
    }
}