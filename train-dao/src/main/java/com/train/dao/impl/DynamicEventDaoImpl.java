package com.train.dao.impl;

import com.train.dao.declare.DynamicEventDao;
import com.train.dao.mapper.DynamicEventMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/15 19:45
 * Description: ${DESCRIPTION}
 */
@Repository
public class DynamicEventDaoImpl implements DynamicEventDao {

    @Resource
    private DynamicEventMapper dynamicEventMapper;

    @Override
    public int insert() {
        return 0;
    }
}
