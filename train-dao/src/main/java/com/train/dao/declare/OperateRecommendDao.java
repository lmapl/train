package com.train.dao.declare;

import com.train.domain.entity.OperateRecommend;

import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/15 14:53
 * Description: ${DESCRIPTION}
 */
public interface OperateRecommendDao {
    List<OperateRecommend> getRecommendByLocation(int location);
}
