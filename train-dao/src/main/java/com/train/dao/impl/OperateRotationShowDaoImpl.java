package com.train.dao.impl;

import com.train.dao.declare.OperateRotationShowDao;
import com.train.dao.mapper.OperateRotationShowMapper;
import com.train.domain.entity.OperateRotationShow;
import com.train.domain.entity.OperateRotationShowExample;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/13 17:59
 * Description: ${DESCRIPTION}
 */
@Repository
public class OperateRotationShowDaoImpl implements OperateRotationShowDao {

    @Resource
    private OperateRotationShowMapper rotationShowMapper;

    @Override
    public List<OperateRotationShow> getRotationShow(int location) {
        OperateRotationShowExample example = new OperateRotationShowExample();
        example.createCriteria().andLocationEqualTo(location);
        return rotationShowMapper.selectByExample(example);
    }
}
