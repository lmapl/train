package com.train.service.common;

import com.train.domain.bean.CollectInfo;
import com.train.domain.bean.DynamicEventInfo;

import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/20 22:48
 * Description: ${DESCRIPTION}
 */
public interface CollectService {
    boolean addCollect(String autograph, CollectInfo dynamicEventInfo);

    List<CollectInfo> getCollect(Integer start, Integer size);

    boolean delCollect(String autograph, Integer id);
}
