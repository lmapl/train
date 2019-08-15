package com.train.dao.impl;

import com.train.dao.OperateRecommendDao;
import com.train.dao.mapper.OperateRecommendMapper;
import com.train.domain.entity.OperateRecommend;
import com.train.domain.entity.OperateRecommendExample;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/15 14:53
 * Description: ${DESCRIPTION}
 */
@Repository
public class OperateRecommendDaoImpl implements OperateRecommendDao {

    @Resource
    private OperateRecommendMapper operateRecommendMapper;

    @Override
    public List<OperateRecommend> getRecommendByLocation(int location) {

        OperateRecommendExample example = new OperateRecommendExample();
        example.createCriteria().andLocationEqualTo(location);
        return operateRecommendMapper.selectByExample(example);
    }
}
