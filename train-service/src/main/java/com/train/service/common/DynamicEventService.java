package com.train.service.common;

import com.train.domain.bean.DynamicEventInfo;

import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/15 19:52
 * Description: ${DESCRIPTION}
 */
public interface DynamicEventService {
    boolean addDynamicEvent(String autograph, DynamicEventInfo dynamicEventInfo);

    List<DynamicEventInfo> getDynamicEvent(Integer start, Integer size);

    boolean delDynamicEvent(String autograph, Integer id);
}
