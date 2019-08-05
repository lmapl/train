package com.train.web.dao;

import java.io.Serializable;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/29 19:25
 * Description: ${DESCRIPTION}
 */
public class IdentityRequest extends BaseRequest implements Serializable{

    private  Integer type;	//身份类型 学生家长=1    教师=2；    机构=3；

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
