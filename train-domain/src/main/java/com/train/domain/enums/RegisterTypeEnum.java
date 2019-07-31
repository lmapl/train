package com.train.domain.enums;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/31 17:45
 * Description: ${DESCRIPTION}
 */
public enum RegisterTypeEnum {

    MOBILE(1, "手机号码注册"),
    WE_CHAT(2, "微信注册");


    private int key;

    private String value;

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    RegisterTypeEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public static RegisterTypeEnum getEnumByKey(Integer key){
        RegisterTypeEnum[] enums = RegisterTypeEnum.values();
        for (RegisterTypeEnum anEnum : enums) {
            if (anEnum.getKey() == key) {
                return anEnum;
            }
        }
        return null;
    }
}
