package com.train.service.common;

import com.train.domain.bean.CommentInfo;

import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/19 22:55
 * Description: ${DESCRIPTION}
 */
public interface CommentService {

    boolean addComment(String autograph, CommentInfo dynamicEventInfo);

    List<CommentInfo> getComment(Integer start, Integer size);

    boolean delComment(String autograph, Integer id);
}
