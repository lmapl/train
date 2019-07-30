package com.train.Exception;

/**
 * Created by Nianzecong
 * Create Date: 2019/7/2 14:47
 * Description: 鉴权失败异常
 */
public class AuthException extends BaseException {

    public AuthException() {
        super(ErrorCode.AUTHENTICATION_EXCEPTION);
    }

    public AuthException(String message) {
        super(ErrorCode.AUTHENTICATION_EXCEPTION, message);
    }

    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }
}
