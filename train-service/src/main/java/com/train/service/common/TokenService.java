package com.train.service.common;

import com.train.domain.bean.UserSessionInfo;

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
     * 登录成功后包装sessionid，并返回用于前端生成登录保持签名
     * userId|uuid|随机数|用户名|平台|有效时间|rediSsessionId|随机数
     * @return
     */
    String getLoginToken(Integer userId,String registerCertificate ,Integer platform,String uuid,String sessionId);

    /**
     * 校验登录保持签名token
     * @param encryptAuth
     * @return
     */
    UserSessionInfo verifyLoginToken(String encryptAuth);

    /**
     * 退出登录
     * @param encryptAuth
     * @return
     */
    Boolean loginOut(String encryptAuth);


}
