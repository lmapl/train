package com.train.dao.impl;

import com.train.dao.declare.CommentDao;
import com.train.dao.mapper.CommentMapper;
import com.train.domain.entity.Comment;
import com.train.domain.entity.CommentExample;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/19 23:05
 * Description: ${DESCRIPTION}
 */
@Repository
public class CommentDaoImpl implements CommentDao {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public int insert(Comment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public List<Comment> getComment(Integer start, Integer size) {
        CommentExample example = new CommentExample();
        example.createCriteria().andIdGreaterThan(size);
        example.setOrderByClause( " id desc limit "+ size);
        return commentMapper.selectByExample(example);
    }

    @Override
    public int delComment(Integer id) {
        CommentExample example = new CommentExample();
        example.createCriteria().andIdEqualTo(id);
        return commentMapper.deleteByExample(example);
    }

    @Override
    public Comment getCommentById(Integer id) {
        CommentExample example = new CommentExample();
        example.createCriteria().andIdEqualTo(id);
        List<Comment>  commentList = commentMapper.selectByExample(example);
        if(commentList.size() == 0){
            return null;
        }
        return commentList.get(0);

    }
}
