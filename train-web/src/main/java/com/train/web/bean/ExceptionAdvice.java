package com.train.web.bean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Nian Zecong
 * Create Date: 2017/12/18 14:27
 * Description: 异常处理切面
 */
@Aspect
@Order(200)
@Component
public class ExceptionAdvice {
    Logger log = LoggerFactory.getLogger(this.getClass().getName());
//
    @Around(value = "execution(* com.train.*.*(..)) ")
    public Object aroundExceptionHandler(ProceedingJoinPoint point) throws Throwable {

        //此句执行业务逻辑方法
        Result result = new Result();
        try {
            result = (Result) point.proceed();
            return result;
        }  catch (Exception e) {
            result.setSuccess(Boolean.FALSE);
            result.setError(new Error(11, "内部错误：" + e.getMessage()));
            return result;
        }
    }
}
