package com.train.dao.impl;

import com.train.dao.declare.CollectDao;
import com.train.dao.mapper.CollectMapper;
import com.train.domain.entity.Collect;
import com.train.domain.entity.CollectExample;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/20 22:55
 * Description: ${DESCRIPTION}
 */
@Repository
public class CollectDaoImpl implements CollectDao {

    @Resource
    private CollectMapper collectMapper;

    @Override
    public int insert(Collect comment) {
        return collectMapper.insert(comment);
    }

    @Override
    public List<Collect> getCollect(Integer start, Integer size) {
        CollectExample example = new CollectExample();
        example.createCriteria().andIdGreaterThan(size);
        example.setOrderByClause( " id desc limit "+ size);
        return collectMapper.selectByExample(example);
    }

    @Override
    public Collect getCollectById(Integer id) {
        CollectExample example = new CollectExample();
        example.createCriteria().andIdEqualTo(id);
        List<Collect>  commentList = collectMapper.selectByExample(example);
        if(commentList.size() == 0){
            return null;
        }
        return commentList.get(0);
    }

    @Override
    public int delCollect(Integer id) {
        CollectExample example = new CollectExample();
        example.createCriteria().andIdEqualTo(id);
        return collectMapper.deleteByExample(example);
    }
}
