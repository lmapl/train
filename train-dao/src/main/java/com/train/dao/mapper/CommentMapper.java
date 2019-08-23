package com.train.dao.mapper;

import com.train.domain.entity.Comment;
import com.train.domain.entity.CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    /**
     *
     * @mbggenerated
     */
    int countByExample(CommentExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(CommentExample example);

    /**
     *
     * @mbggenerated
     */
    int insert(Comment record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(Comment record);

    /**
     *
     * @mbggenerated
     */
    List<Comment> selectByExample(CommentExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);
}