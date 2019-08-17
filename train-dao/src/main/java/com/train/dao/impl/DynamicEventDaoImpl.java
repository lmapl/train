package com.train.dao.impl;

import com.train.dao.declare.DynamicEventDao;
import com.train.dao.mapper.DynamicEventMapper;
import com.train.domain.entity.DynamicEvent;
import com.train.domain.entity.DynamicEventExample;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

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
    public int insert(DynamicEvent dynamicEvent) {
        return dynamicEventMapper.insert(dynamicEvent);
    }

    @Override
    public List<DynamicEvent> getDynamicEvent(Integer start, Integer size) {
        DynamicEventExample example = new DynamicEventExample();
        example.createCriteria().andIdGreaterThan(size);
        example.setOrderByClause( " id desc limit "+ size);
        return dynamicEventMapper.selectByExample(example);
    }

    @Override
    public DynamicEvent getDynamicEventById(Integer id) {
        DynamicEventExample example = new DynamicEventExample();
        example.createCriteria().andIdEqualTo(id);
        List<DynamicEvent>  dynamicEventList = dynamicEventMapper.selectByExample(example);
        if(dynamicEventList.size() == 0){
            return null;
        }
        return dynamicEventList.get(0);
    }

    @Override
    public int delDynamicEvent(Integer id) {
        DynamicEventExample example = new DynamicEventExample();
        example.createCriteria().andIdEqualTo(id);
        return dynamicEventMapper.deleteByExample(example);
    }
}
