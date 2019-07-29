package com.train.service.common;

import org.springframework.stereotype.Service;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/29 11:47
 * Description: ${DESCRIPTION}
 */
@Service
public interface TokenService {

    String  getServerToken(String uuid);

}
