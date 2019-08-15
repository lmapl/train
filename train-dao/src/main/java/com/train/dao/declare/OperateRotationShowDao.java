package com.train.dao.declare;

import com.train.domain.entity.OperateRotationShow;

import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/13 17:59
 * Description: ${DESCRIPTION}
 */
public interface OperateRotationShowDao {
    List<OperateRotationShow> getRotationShow(int location);
}
