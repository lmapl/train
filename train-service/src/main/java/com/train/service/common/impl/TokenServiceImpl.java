package com.train.service.common.impl;

import com.train.service.common.TokenService;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/29 11:50
 * Description: ${DESCRIPTION}
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Value("server.rsa.publickey")
    private String serverRsaPublicKey;

    @Value("server.rsa.privatekey")
    private String serverRsaPrivateKey;

    @Override
    public String getServerToken(String uuid) {
        return null;
    }
}
