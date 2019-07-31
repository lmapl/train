package com.train.domain.enums;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/31 16:10
 * Description: ${DESCRIPTION}
 */
public enum UserTypeEnum {

    PENDING(0, "待定"),
    STU_PARENT(1, "学生家长"),
    TEACHER(2, "老师"),
    COMPANY(3, "机构"),
    ;

    private int key;

    private String value;

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    UserTypeEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public static UserTypeEnum getEnumByKey(Integer key){
        UserTypeEnum[] enums = UserTypeEnum.values();
        for (UserTypeEnum anEnum : enums) {
            if (anEnum.getKey() == key) {
                return anEnum;
            }
        }
        return null;
    }

}
