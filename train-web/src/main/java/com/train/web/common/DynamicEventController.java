package com.train.web.common;

import com.train.Exception.InvalidParamException;
import com.train.domain.bean.DynamicEventInfo;
import com.train.service.common.DynamicEventService;
import com.train.web.bean.Result;
import com.train.web.dao.DelBaseRequest;
import com.train.web.dao.DynamicEventDao;
import com.train.web.dao.DynamicEventRequest;
import com.train.web.dao.QueryBaseRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/19 23:35
 * Description: ${DESCRIPTION}
 */
@RequestMapping("/dynamicEvent")
@RestController
public class DynamicEventController {

    @Resource
    private DynamicEventService dynamicEventService;

    @RequestMapping(value ="/addDynamicEvent/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> addDynamicEvent(@RequestBody DynamicEventRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph())
                ){
            throw new InvalidParamException("参数为空");
        }


        DynamicEventInfo dynamicEventInfo = new DynamicEventInfo();
        BeanUtils.copyProperties(dynamicEventInfo,request);
        boolean flag = dynamicEventService.addDynamicEvent(request.getAutograph(),dynamicEventInfo);
        result.setData(flag);
        return result;
    }


    @RequestMapping(value ="/getDynamicEvent/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<List<DynamicEventDao>> getDynamicEvent(@RequestBody QueryBaseRequest request){
        Result<List<DynamicEventDao>> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph())
                ){
            throw new InvalidParamException("参数为空");
        }

        List<DynamicEventInfo> eventInfoList = dynamicEventService.getDynamicEvent(request.getStart(),request.getSize());
        List<DynamicEventDao> dynamicEventDaoList = new ArrayList<>();
        if(CollectionUtils.isEmpty(eventInfoList)){
            DynamicEventDao dao;
            for(DynamicEventInfo info : eventInfoList){
                dao = new DynamicEventDao();
                BeanUtils.copyProperties(info,dao);
                dynamicEventDaoList.add(dao);
            }
        }
        result.setData(dynamicEventDaoList);
        return result;
    }

    @RequestMapping(value ="/delDynamicEvent/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delDynamicEvent(@RequestBody DelBaseRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph())
                ){
            throw new InvalidParamException("参数为空");
        }

        boolean flag = dynamicEventService.delDynamicEvent(request.getAutograph(),request.getId());
        result.setData(flag);
        return result;
    }

}
