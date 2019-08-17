package com.train.web.dao;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/17 22:11
 * Description: ${DESCRIPTION}
 */
public class QueryBaseRequest extends BaseRequest {

    /**
     *
     */
    private Integer start;


    private Integer size;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
