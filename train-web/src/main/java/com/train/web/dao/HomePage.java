package com.train.web.dao;

import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/10 18:15
 * Description: ${DESCRIPTION}
 */
public class HomePage {

    private List<RotationShowDto> rotationShow;//	轮播位		是
    private List<CompanyDto> selectedCompany;	//精选机构推荐位		否
    private RecommendDto recommend;	//推荐位		否
    private List<CompanyDto> normalCompany;	//常规机构位		是

    public List<RotationShowDto> getRotationShow() {
        return rotationShow;
    }

    public void setRotationShow(List<RotationShowDto> rotationShow) {
        this.rotationShow = rotationShow;
    }

    public List<CompanyDto> getSelectedCompany() {
        return selectedCompany;
    }

    public void setSelectedCompany(List<CompanyDto> selectedCompany) {
        this.selectedCompany = selectedCompany;
    }

    public RecommendDto getRecommend() {
        return recommend;
    }

    public void setRecommend(RecommendDto recommend) {
        this.recommend = recommend;
    }

    public List<CompanyDto> getNormalCompany() {
        return normalCompany;
    }

    public void setNormalCompany(List<CompanyDto> normalCompany) {
        this.normalCompany = normalCompany;
    }
}
