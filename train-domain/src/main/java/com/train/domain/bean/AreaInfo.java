package com.train.domain.bean;

import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/5 20:16
 * Description: ${DESCRIPTION}
 */
public class AreaInfo {
    private Integer id;	 //id	Integer
    private String name	;//名称
    private List<AreaInfo> childAreaList	;//子一级地址


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

    public List<AreaInfo> getChildAreaList() {
        return childAreaList;
    }

    public void setChildAreaList(List<AreaInfo> childAreaList) {
        this.childAreaList = childAreaList;
    }
}
