package com.train.domain.enums;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/31 16:10
 * Description: ${DESCRIPTION}
 */
public enum LocationEnum {

    USER_STU_PARENT_HOME(1, "学生家长客户端首页"),
    Company_HOME(2, "机构客户端首页"),
    ;

    private int key;

    private String value;

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    LocationEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public static LocationEnum getEnumByKey(Integer key){
        LocationEnum[] enums = LocationEnum.values();
        for (LocationEnum anEnum : enums) {
            if (anEnum.getKey() == key) {
                return anEnum;
            }
        }
        return null;
    }

}
