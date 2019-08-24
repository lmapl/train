package com.train.web.dao;

import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/10 18:15
 * Description: ${DESCRIPTION}
 */
public class CompanyHomePage {

    private List<RotationShowDto> rotationShow;//	轮播位		是
    private List<TeacherDto> selectedTeacherDto;	//精选教师推荐位		否
    private RecommendDto recommend;	//推荐位		否
    private List<TeacherDto> normalTeacherDto;	//常规教师位		是

    public List<RotationShowDto> getRotationShow() {
        return rotationShow;
    }

    public void setRotationShow(List<RotationShowDto> rotationShow) {
        this.rotationShow = rotationShow;
    }

    public RecommendDto getRecommend() {
        return recommend;
    }

    public void setRecommend(RecommendDto recommend) {
        this.recommend = recommend;
    }

    public List<TeacherDto> getSelectedTeacherDto() {
        return selectedTeacherDto;
    }

    public void setSelectedTeacherDto(List<TeacherDto> selectedTeacherDto) {
        this.selectedTeacherDto = selectedTeacherDto;
    }

    public List<TeacherDto> getNormalTeacherDto() {
        return normalTeacherDto;
    }

    public void setNormalTeacherDto(List<TeacherDto> normalTeacherDto) {
        this.normalTeacherDto = normalTeacherDto;
    }
}
