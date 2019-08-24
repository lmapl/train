package com.train.web.dao;

import java.io.Serializable;

public class UserTeacherRequest extends  BaseRequest  implements Serializable{

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
