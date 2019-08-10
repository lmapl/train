package com.train.dao;

import com.train.domain.entity.AddrArea;

import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/8 10:47
 * Description: ${DESCRIPTION}
 */
public interface AddrAreaDao {

    List<AddrArea> getValidAreaByType(Integer scope);

    List<AddrArea> getValidAreaByFather(List<Integer> idList);
}
