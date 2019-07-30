package com.train.Exception;

/**
 * Created by nianzecong
 * Create Date: 2018/12/22 12:56
 * Description: 内部服务异常
 */
public class InternalServerException extends BaseException{

    public InternalServerException(){
        super(ErrorCode.INTERNAL_SERVER_EXCEPTION);
    }

    public InternalServerException(String msg){
        super(ErrorCode.INTERNAL_SERVER_EXCEPTION, msg);
    }

    public InternalServerException(String msg, Throwable e){
        super(ErrorCode.INTERNAL_SERVER_EXCEPTION, msg, e);
    }

}
