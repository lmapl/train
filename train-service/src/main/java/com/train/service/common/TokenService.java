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
     * @param encryptAuth
     * @return
     */
    boolean verifyNotLoginToken(Integer type ,String encryptAuth);

    /**
     * 获取登录成功后的保持登录的token
     * userId|uuid|随机数|用户名|平台|有效时间|rediSsessionId|随机数
     * @return
     */
    String getLoginToken(Integer userId,String registerCertificate ,Integer platform,String uuid,String sessionId);


}
