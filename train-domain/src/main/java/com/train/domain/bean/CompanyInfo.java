package com.train.domain.bean;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/3 17:25
 * Description: ${DESCRIPTION}
 */
public class CompanyInfo {

    private Integer id	; //id		是
    private String name;	//机构名称		否
    private String portrait	;//logo图片地址
    private String position;	//位置	String	是	需要分割符，待定
    private String subjects	;//科目			物理、化学，语文等组成的字符串
    private Integer collectedNumber;//	被收藏人数
    private Integer evaluationGrade	;//评价等级

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public Integer getCollectedNumber() {
        return collectedNumber;
    }

    public void setCollectedNumber(Integer collectedNumber) {
        this.collectedNumber = collectedNumber;
    }

    public Integer getEvaluationGrade() {
        return evaluationGrade;
    }

    public void setEvaluationGrade(Integer evaluationGrade) {
        this.evaluationGrade = evaluationGrade;
    }
}
