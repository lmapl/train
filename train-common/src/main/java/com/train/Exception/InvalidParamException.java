package com.train.Exception;

/**
 * Created by nianzecong
 * Create Date: 2018/12/22 12:56
 * Description: 参数错误
 */
public class InvalidParamException extends BaseException{

    public InvalidParamException(){
        super(ErrorCode.COMMON_PARAM_ERROR);
    }

    public InvalidParamException(String msg){
        super(ErrorCode.COMMON_PARAM_ERROR, msg);
    }

    public InvalidParamException(String msg, Throwable e){
        super(ErrorCode.COMMON_PARAM_ERROR, msg, e);
    }

}
