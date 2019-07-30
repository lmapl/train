package com.train.Exception;

/**
 * Created by 骆俊武
 * Create Date: 2017/8/22 12:56
 * Description: 错误码和错误信息定义
 */
public enum ErrorCode {
    /* 1-100 预留作为通用异常 */
    INTERNAL_SERVER_EXCEPTION(-1, "内部服务异常"),
    COMMON_PARAM_NULL(1, "参数不能为空"),
    COMMON_PARAM_ERROR(2, "参数错误"),
    THIRD_PARTY_SERVICE_EXCEPTION(3, "第三方依赖服务异常"),
    AUTHENTICATION_EXCEPTION(4, "鉴权失败"),
    RATE_LIMIT(5, "调用频率超限"),

    SN_DECODE_EXCEPTION(101, "将sn转换成礼包ID异常"),

    FEED_BACK_LIMIT(201, "用户反馈次数限制"),

    GOLD_REPEAT_LIMIT(301, "用户重复挖宝"),
    GOLD_HELP_EXCEED_LIMIT(302, "用户超限制挖宝"),
    GOLD_ACCOUNT_EXCEPTION(303, "正在处理挖宝账户"),
    GOLD_HLEP_RECEIVE_EXCEPTION(304, "正在处理帮挖"),
    GOLD_HLEP_RECEIVE_FORBIT(305, "禁止自己给自己帮挖"),
    GOLD_ACCOUNT_BALANCE_INSUFFICIENT(401, "余额不足"),

    HANGUP_PRIVILEGE_AMOUNT_INVALID_TASK(501, "活动配置异常"),
        ;

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
