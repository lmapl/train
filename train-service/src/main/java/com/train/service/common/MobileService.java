package com.train.service.common;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/29 16:23
 * Description: ${DESCRIPTION}
 */
public interface MobileService {

    void getMobileVerifyCode(String uuid,String mobile, String token);

    boolean verifyCode(String mobile, String code);
}
