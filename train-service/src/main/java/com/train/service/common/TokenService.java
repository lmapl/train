package com.train.service.common;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/29 11:47
 * Description: ${DESCRIPTION}
 */
public interface TokenService {

    /**
     * 获取服务器token
     * @param type
     * @param uuid
     * @return
     */
    String  getServerToken(String type ,String uuid);

    /**
     * 校验token
     * @param type
     * @param uuid
     * @param encrypt
     * @return
     */
    boolean verifyToken(String type ,String uuid,String encrypt,String mobile);

}
