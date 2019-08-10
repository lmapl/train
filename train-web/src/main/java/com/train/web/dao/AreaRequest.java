package com.train.web.dao;

import java.io.Serializable;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/3 17:18
 * Description: ${DESCRIPTION}
 */
public class AreaRequest extends BaseRequest implements Serializable {


    //层级划分： 1地区 2 省份；3市 ；4县区；
    private Integer scope;

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }
}
