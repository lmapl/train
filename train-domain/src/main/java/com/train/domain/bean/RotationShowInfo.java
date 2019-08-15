package com.train.domain.bean;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/10 18:17
 * Description: ${DESCRIPTION}
 */
public class RotationShowInfo {

    private Integer type;	//类型
    private String content;	//内容	图片地址，视频地址，文案等等

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
