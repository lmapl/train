package com.train.domain.bean;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/5 15:56
 * Description: ${DESCRIPTION}
 */
public class CompanyCurriculumInfo {

    private Integer id;

    private  Integer subjectId;	//科目 物理、化学，语文等
    private String curriculumName;	//课程名称
    private Integer	period ; //课时
    private Integer minNumber;//	开班最低人数
    private Integer maxNumber;//	开班最低人数
    private Integer price;//	课程价格
    private String contactNumber;//	咨询电话
    private String startTime;//	开始时间
    private String endTime;//	结束时间
    private String teachingTime;//	上课时间	多个时间以；分割
    private Integer companyTeacherId;//	授课机构老师id
    private String remark;//	备注
    private String contactTel;


    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getMinNumber() {
        return minNumber;
    }

    public void setMinNumber(Integer minNumber) {
        this.minNumber = minNumber;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTeachingTime() {
        return teachingTime;
    }

    public void setTeachingTime(String teachingTime) {
        this.teachingTime = teachingTime;
    }

    public Integer getCompanyTeacherId() {
        return companyTeacherId;
    }

    public void setCompanyTeacherId(Integer companyTeacherId) {
        this.companyTeacherId = companyTeacherId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }
}
