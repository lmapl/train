package com.train.dao.impl;

import com.train.dao.AddrAreaDao;
import com.train.dao.mapper.AddrAreaMapper;
import com.train.domain.entity.AddrArea;
import com.train.domain.entity.AddrAreaExample;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/8 10:47
 * Description: ${DESCRIPTION}
 */
@Repository
public class AddrAreaDaoImpl implements AddrAreaDao {

    @Resource
    private AddrAreaMapper addrAreaMapper;

    @Override
    public List<AddrArea> getValidAreaByType(Integer scope) {
        AddrAreaExample example = new AddrAreaExample();
        example.createCriteria().andTypeEqualTo(scope).andIsEnableEqualTo(1);
        return addrAreaMapper.selectByExample(example);
    }

    @Override
    public List<AddrArea> getValidAreaByFather(List<Integer> idList) {
        AddrAreaExample example = new AddrAreaExample();
        example.createCriteria().andFatherIdIn(idList).andIsEnableEqualTo(1);
        return addrAreaMapper.selectByExample(example);
    }
}
