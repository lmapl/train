package com.train.dao.declare;

import com.train.domain.entity.Comment;
import com.train.domain.entity.DynamicEvent;

import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/19 23:04
 * Description: ${DESCRIPTION}
 */
public interface CommentDao {
    int insert(Comment comment);

    List<Comment> getComment(Integer start, Integer size);

    int delComment(Integer id);

    Comment getCommentById(Integer id);
}
