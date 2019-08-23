package com.train.service.common.impl;

import com.train.dao.declare.CommentDao;
import com.train.domain.bean.CommentInfo;
import com.train.domain.bean.DynamicEventInfo;
import com.train.domain.bean.UserSessionInfo;
import com.train.domain.entity.Comment;
import com.train.domain.entity.DynamicEvent;
import com.train.service.common.CommentService;
import com.train.service.common.TokenService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/19 22:56
 * Description: ${DESCRIPTION}
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentDao commentDao;

    @Resource
    private TokenService tokenService;

    @Override
    public boolean addComment(String autograph, CommentInfo dynamicEventInfo) {
        if(StringUtils.isEmpty(autograph) || dynamicEventInfo == null ){
            return false;
        }

        UserSessionInfo session = tokenService.verifyLoginToken(autograph);
        if(session == null || session.getSessionId() == null){
            return false;
        }

        Comment comment = new Comment();
        comment.setContent(dynamicEventInfo.getContent());
        comment.setUserId(session.getUserId());
        comment.setCreateBy(session.getUserId()+"");
        comment.setCreateTime(new Date());

        return commentDao.insert(comment) == 1;
    }

    @Override
    public List<CommentInfo> getComment(Integer start, Integer size) {
        List<Comment> dynamicEventList =  commentDao.getComment(start,size);
        if(CollectionUtils.isEmpty(dynamicEventList)){
            return new ArrayList<>();
        }

        List<CommentInfo> infoList = new ArrayList<>();
        CommentInfo info;
        for(Comment dynamicEvent : dynamicEventList){
            info = new CommentInfo();
            BeanUtils.copyProperties(dynamicEvent,info);
            infoList.add(info);
        }
        return infoList;
    }

    @Override
    public boolean delComment(String autograph, Integer id) {
        if(StringUtils.isEmpty(autograph) || id == null ){
            return false;
        }

        UserSessionInfo session = tokenService.verifyLoginToken(autograph);
        if(session == null || session.getSessionId() == null){
            return false;
        }

        Comment event = commentDao.getCommentById(id);
        if(event == null || event.getUserId().intValue() != session.getUserId()){
            return false;
        }

        return commentDao.delComment(id) == 1;
    }
}
