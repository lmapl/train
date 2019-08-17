package com.train.service.common.impl;

import com.train.dao.declare.DynamicEventDao;
import com.train.domain.bean.DynamicEventInfo;
import com.train.domain.bean.UserSessionInfo;
import com.train.domain.entity.DynamicEvent;
import com.train.domain.entity.User;
import com.train.service.common.DynamicEventService;
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
 * Create Date: 2019/8/15 19:52
 * Description: ${DESCRIPTION}
 */
@Service
public class DynamicEventServiceImpl implements DynamicEventService {

    @Resource
    private TokenService tokenService;

    @Resource
    private DynamicEventDao dynamicEventDao;

    @Override
    public boolean addDynamicEvent(String autograph, DynamicEventInfo dynamicEventInfo) {

        if(StringUtils.isEmpty(autograph) || dynamicEventInfo == null ){
            return false;
        }

        UserSessionInfo session = tokenService.verifyLoginToken(autograph);
        if(session == null || session.getSessionId() == null){
            return false;
        }

        DynamicEvent dynamicEvent = new DynamicEvent();
        dynamicEvent.setContent(dynamicEventInfo.getContent());
        dynamicEvent.setTitle(dynamicEventInfo.getTitle());
        dynamicEvent.setImgUrl(dynamicEventInfo.getImgUrl());
        dynamicEvent.setVideoUrl(dynamicEventInfo.getVideoUrl());
        dynamicEvent.setUserId(session.getUserId());
        dynamicEvent.setCreateBy(session.getUserId()+"");
        dynamicEvent.setCreateTime(new Date());

        return dynamicEventDao.insert(dynamicEvent) == 1;
    }

    @Override
    public List<DynamicEventInfo> getDynamicEvent(Integer start, Integer size) {
        List<DynamicEvent> dynamicEventList =  dynamicEventDao.getDynamicEvent(start,size);
        if(CollectionUtils.isEmpty(dynamicEventList)){
            return new ArrayList<>();
        }

        List<DynamicEventInfo> infoList = new ArrayList<>();
        DynamicEventInfo info;
        for(DynamicEvent dynamicEvent : dynamicEventList){
            info = new DynamicEventInfo();
            BeanUtils.copyProperties(dynamicEvent,info);
            infoList.add(info);
        }
        return infoList;
    }

    @Override
    public boolean delDynamicEvent(String autograph, Integer id) {
        if(StringUtils.isEmpty(autograph) || id == null ){
            return false;
        }

        UserSessionInfo session = tokenService.verifyLoginToken(autograph);
        if(session == null || session.getSessionId() == null){
            return false;
        }

        DynamicEvent event = dynamicEventDao.getDynamicEventById(id);
        if(event == null || event.getUserId().intValue() != session.getUserId()){
            return false;
        }

        return dynamicEventDao.delDynamicEvent(id) == 1;
    }
}
