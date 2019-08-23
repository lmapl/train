package com.train.service.common.impl;

import com.train.dao.declare.CollectDao;
import com.train.domain.bean.CollectInfo;
import com.train.domain.bean.CommentInfo;
import com.train.domain.bean.DynamicEventInfo;
import com.train.domain.bean.UserSessionInfo;
import com.train.domain.entity.Collect;
import com.train.domain.entity.Comment;
import com.train.service.common.CollectService;
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
 * Create Date: 2019/8/20 22:48
 * Description: ${DESCRIPTION}
 */
@Service
public class CollectServiceImpl implements CollectService {

    @Resource
    private CollectDao collectDao;

    @Resource
    private TokenService tokenService;


    @Override
    public boolean addCollect(String autograph, CollectInfo dynamicEventInfo) {
        if(StringUtils.isEmpty(autograph) || dynamicEventInfo == null ){
            return false;
        }

        UserSessionInfo session = tokenService.verifyLoginToken(autograph);
        if(session == null || session.getSessionId() == null){
            return false;
        }

        Collect comment = new Collect();
        comment.setUserId(session.getUserId());
        comment.setCreateBy(session.getUserId()+"");
        comment.setCreateTime(new Date());

        return collectDao.insert(comment) == 1;
    }

    @Override
    public List<CollectInfo> getCollect(Integer start, Integer size) {
        List<Collect> dynamicEventList =  collectDao.getCollect(start,size);
        if(CollectionUtils.isEmpty(dynamicEventList)){
            return new ArrayList<>();
        }

        List<CollectInfo> infoList = new ArrayList<>();
        CollectInfo info;
        for(Collect dynamicEvent : dynamicEventList){
            info = new CollectInfo();
            BeanUtils.copyProperties(dynamicEvent,info);
            infoList.add(info);
        }
        return infoList;
    }

    @Override
    public boolean delCollect(String autograph, Integer id) {
        if(StringUtils.isEmpty(autograph) || id == null ){
            return false;
        }

        UserSessionInfo session = tokenService.verifyLoginToken(autograph);
        if(session == null || session.getSessionId() == null){
            return false;
        }

        Collect event = collectDao.getCollectById(id);
        if(event == null || event.getUserId().intValue() != session.getUserId()){
            return false;
        }

        return collectDao.delCollect(id) == 1;
    }
}
