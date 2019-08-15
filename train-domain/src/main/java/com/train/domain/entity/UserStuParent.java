package com.train.domain.entity;

import java.util.Date;

public class UserStuParent {
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
     * 性别1=男； 2=女
     */
    private Integer gender;

    /**
     * 生日
     */
    private String birthdayYear;

    /**
     * 
     */
    private String birthdayMonth;

    /**
     * 
     */
    private String birthdayDay;

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
     * 性别1=男； 2=女
     * @return gender 性别1=男； 2=女
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 性别1=男； 2=女
     * @param gender 性别1=男； 2=女
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 生日
     * @return birthday_year 生日
     */
    public String getBirthdayYear() {
        return birthdayYear;
    }

    /**
     * 生日
     * @param birthdayYear 生日
     */
    public void setBirthdayYear(String birthdayYear) {
        this.birthdayYear = birthdayYear == null ? null : birthdayYear.trim();
    }

    /**
     * 
     * @return birthday_month 
     */
    public String getBirthdayMonth() {
        return birthdayMonth;
    }

    /**
     * 
     * @param birthdayMonth 
     */
    public void setBirthdayMonth(String birthdayMonth) {
        this.birthdayMonth = birthdayMonth == null ? null : birthdayMonth.trim();
    }

    /**
     * 
     * @return birthday_day 
     */
    public String getBirthdayDay() {
        return birthdayDay;
    }

    /**
     * 
     * @param birthdayDay 
     */
    public void setBirthdayDay(String birthdayDay) {
        this.birthdayDay = birthdayDay == null ? null : birthdayDay.trim();
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
        sb.append(", nickname=").append(nickname);
        sb.append(", portrait=").append(portrait);
        sb.append(", gender=").append(gender);
        sb.append(", birthdayYear=").append(birthdayYear);
        sb.append(", birthdayMonth=").append(birthdayMonth);
        sb.append(", birthdayDay=").append(birthdayDay);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append("]");
        return sb.toString();
    }
}