package com.train.web.dao;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/10 18:17
 * Description: ${DESCRIPTION}
 */
public class RecommendDto {

    private String name;	//名称（标题）		否
    private String portrait	;//图片地址

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
}
