package com.train.Exception;

/**
 * Created by 年泽聪
 * Create Date: 2017/8/22 12:56
 * Description: 调用频率受限
 */
public class RateLimitException extends BaseException{

    public RateLimitException(){
        super(ErrorCode.RATE_LIMIT);
    }

    public RateLimitException(String msg){
        super(ErrorCode.RATE_LIMIT, msg);
    }

    public RateLimitException(String msg, Throwable e){
        super(ErrorCode.RATE_LIMIT, msg, e);
    }

}
