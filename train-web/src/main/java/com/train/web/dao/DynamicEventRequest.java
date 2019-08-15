package com.train.web.dao;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/15 19:27
 * Description: ${DESCRIPTION}
 */
public class DynamicEventRequest extends BaseRequest{

    private String  copyWriting;//	文案	String
    private  String viewUrl;//	视图地址	String
    private String  position;//	位置	String


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getViewUrl() {
        return viewUrl;
    }

    public void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
    }

    public String getCopyWriting() {
        return copyWriting;
    }

    public void setCopyWriting(String copyWriting) {
        this.copyWriting = copyWriting;
    }
}
