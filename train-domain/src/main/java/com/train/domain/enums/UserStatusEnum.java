package com.train.domain.enums;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/31 16:10
 * Description: ${DESCRIPTION}
 */
public enum UserStatusEnum {

    VALID(1, "生效"),
    CANCELLED(2, "被注销"),
    MERGED(3, "被合并"),
    FORBID(4, "被禁止");


    private int key;

    private String value;

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    UserStatusEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public static UserStatusEnum getEnumByKey(Integer key){
        UserStatusEnum[] enums = UserStatusEnum.values();
        for (UserStatusEnum anEnum : enums) {
            if (anEnum.getKey() == key) {
                return anEnum;
            }
        }
        return null;
    }

}
