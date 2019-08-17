package com.train.dao.declare;

import com.train.domain.entity.DynamicEvent;

import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/15 19:44
 * Description: ${DESCRIPTION}
 */
public interface DynamicEventDao {

    int insert(DynamicEvent dynamicEvent);

    List<DynamicEvent> getDynamicEvent(Integer start, Integer size);

    DynamicEvent getDynamicEventById(Integer id);

    int delDynamicEvent(Integer id);
}
