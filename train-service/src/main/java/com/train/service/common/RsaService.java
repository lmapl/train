package com.train.service.common;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/30 19:53
 * Description: ${DESCRIPTION}
 */
public interface RsaService {

    /**
     * 解密
     * @param encrypt
     * @return
     */
    String decryptByPrivateKey(String encrypt);

    /**
     * 加密
     * @param str
     * @return
     */
    String encryptByPublicKey(String str);
}
