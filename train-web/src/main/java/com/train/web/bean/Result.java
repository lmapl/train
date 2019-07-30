package com.train.web.bean;

import java.io.Serializable;

/**
 *
 * @param <T>
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -7837410799878026593L;

    public boolean success; // 成功标记
    public Error error; // 错误信息
    private T data; // 业务数据

    public Result() {
        this.success = true;
    }

    public Result(boolean success, T data) {
        this.data = data;
        this.success = success;
    }

    public Result(boolean success, int errorCode, String message) {
        Error err = new Error(errorCode, message);
        this.error = err;
        this.data = null;
        this.success = success;
    }

    public Result(boolean success, int errorCode, String message, T data) {
        Error err = new Error(errorCode, message);
        this.error = err;
        this.data = data;
        this.success = success;
    }

    /**
     * @return 成功标记
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * @param success 成功标记
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * @return 错误信息
     */
    public Error getError() {
        return error;
    }

    /**
     * @param error 错误信息
     */
    public void setError(Error error) {
        this.error = error;
    }

    /**
     * @return 业务数据
     */
    public T getData() {
        return data;
    }

    /**
     * @param data 业务数据
     */
    public void setData(T data) {
        this.data = data;
    }
}
