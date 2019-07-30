package com.train.web.bean;

import java.io.Serializable;

/**
 *
 */
public class Error implements Serializable {
    private static final long serialVersionUID = 5501282806034703755L;

    private int errorCode; // 错误码
    private String errorMessage; // 错误信息

    public Error(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * @return 错误码
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode 错误码
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return 错误信息
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage 错误信息
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
