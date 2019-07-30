package com.train.service.common.impl;

import com.train.service.common.RsaService;
import com.train.utils.RSAUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/30 19:53
 * Description: ${DESCRIPTION}
 */
@Service
public class RsaServiceImpl implements RsaService{

    @Value("${server.rsa.privatekey}")
    private String serverRsaPrivateKey;

    @Value("${client.rsa.publickey}")
    private String clientRsaPublicKey;

    @Override
    public String decryptByPrivateKey(String encrypt) {
        return RSAUtils.decryptByPrivateKey(encrypt,serverRsaPrivateKey);
    }

    @Override
    public String encryptByPublicKey(String str) {
        return RSAUtils.encryptByPublicKey(str, clientRsaPublicKey);
    }
}
