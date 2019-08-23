package com.train.dao.declare;

import com.train.domain.entity.Collect;
import com.train.domain.entity.Comment;

import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/20 22:55
 * Description: ${DESCRIPTION}
 */
public interface CollectDao {
    int insert(Collect comment);

    List<Collect> getCollect(Integer start, Integer size);

    Collect getCollectById(Integer id);

    int delCollect(Integer id);
}
