package com.train.domain.entity;

import java.util.Date;

public class CompanyCurriculum {
    /**
     * 自增主键,课程id
     */
    private Integer id;

    /**
     * 科目,物理、化学，语文等
     */
    private Integer subjectId;

    /**
     * 课程名称
     */
    private String curriculumName;

    /**
     * 课时
     */
    private Integer period;

    /**
     * 开班最低人数
     */
    private Integer minNumber;

    /**
     * 开班最低人数
     */
    private Integer maxNumber;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 咨询电话
     */
    private String contactTel;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 上课时间 多个时间以；分割
     */
    private String teachingTime;

    /**
     * 授课机构老师id
     */
    private Integer companyTeacherId;

    /**
     * 备注
     */
    private String remark;

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
     * 自增主键,课程id
     * @return id 自增主键,课程id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 自增主键,课程id
     * @param id 自增主键,课程id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 科目,物理、化学，语文等
     * @return subject_id 科目,物理、化学，语文等
     */
    public Integer getSubjectId() {
        return subjectId;
    }

    /**
     * 科目,物理、化学，语文等
     * @param subjectId 科目,物理、化学，语文等
     */
    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * 课程名称
     * @return curriculum_name 课程名称
     */
    public String getCurriculumName() {
        return curriculumName;
    }

    /**
     * 课程名称
     * @param curriculumName 课程名称
     */
    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName == null ? null : curriculumName.trim();
    }

    /**
     * 课时
     * @return period 课时
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     * 课时
     * @param period 课时
     */
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     * 开班最低人数
     * @return min_number 开班最低人数
     */
    public Integer getMinNumber() {
        return minNumber;
    }

    /**
     * 开班最低人数
     * @param minNumber 开班最低人数
     */
    public void setMinNumber(Integer minNumber) {
        this.minNumber = minNumber;
    }

    /**
     * 开班最低人数
     * @return max_number 开班最低人数
     */
    public Integer getMaxNumber() {
        return maxNumber;
    }

    /**
     * 开班最低人数
     * @param maxNumber 开班最低人数
     */
    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    /**
     * 价格
     * @return price 价格
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 价格
     * @param price 价格
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 咨询电话
     * @return contact_tel 咨询电话
     */
    public String getContactTel() {
        return contactTel;
    }

    /**
     * 咨询电话
     * @param contactTel 咨询电话
     */
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel == null ? null : contactTel.trim();
    }

    /**
     * 开始时间
     * @return start_time 开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 开始时间
     * @param startTime 开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    /**
     * 结束时间
     * @return end_time 结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 结束时间
     * @param endTime 结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    /**
     * 上课时间 多个时间以；分割
     * @return teaching_Time 上课时间 多个时间以；分割
     */
    public String getTeachingTime() {
        return teachingTime;
    }

    /**
     * 上课时间 多个时间以；分割
     * @param teachingTime 上课时间 多个时间以；分割
     */
    public void setTeachingTime(String teachingTime) {
        this.teachingTime = teachingTime == null ? null : teachingTime.trim();
    }

    /**
     * 授课机构老师id
     * @return company_Teacher_Id 授课机构老师id
     */
    public Integer getCompanyTeacherId() {
        return companyTeacherId;
    }

    /**
     * 授课机构老师id
     * @param companyTeacherId 授课机构老师id
     */
    public void setCompanyTeacherId(Integer companyTeacherId) {
        this.companyTeacherId = companyTeacherId;
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        sb.append(", subjectId=").append(subjectId);
        sb.append(", curriculumName=").append(curriculumName);
        sb.append(", period=").append(period);
        sb.append(", minNumber=").append(minNumber);
        sb.append(", maxNumber=").append(maxNumber);
        sb.append(", price=").append(price);
        sb.append(", contactTel=").append(contactTel);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", teachingTime=").append(teachingTime);
        sb.append(", companyTeacherId=").append(companyTeacherId);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append("]");
        return sb.toString();
    }
}