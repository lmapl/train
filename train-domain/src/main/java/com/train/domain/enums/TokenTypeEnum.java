package com.train.domain.enums;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/31 17:45
 * Description: ${DESCRIPTION}
 */
public enum TokenTypeEnum {

    MOBILE_CODE(1, "手机验证码获取"),
    LOGIN(2, "登录");


    private int key;

    private String value;

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    TokenTypeEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public static TokenTypeEnum getEnumByKey(Integer key){
        TokenTypeEnum[] enums = TokenTypeEnum.values();
        for (TokenTypeEnum anEnum : enums) {
            if (anEnum.getKey() == key) {
                return anEnum;
            }
        }
        return null;
    }
}
