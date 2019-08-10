package com.train.service.common;

import com.train.domain.bean.AreaInfo;

import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/5 20:14
 * Description: ${DESCRIPTION}
 */
public interface AreaService {
    List<AreaInfo> getArea(Integer scope);
}
