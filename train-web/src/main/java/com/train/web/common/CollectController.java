package com.train.web.common;

import com.train.Exception.InvalidParamException;
import com.train.domain.bean.CollectInfo;
import com.train.domain.bean.DynamicEventInfo;
import com.train.service.common.CollectService;
import com.train.service.common.DynamicEventService;
import com.train.web.bean.Result;
import com.train.web.dao.*;
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
@RequestMapping("/collect")
@RestController
public class CollectController {

    @Resource
    private CollectService collectService;

    @RequestMapping(value ="/addCollect/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> addCollect(@RequestBody CollectRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph())
                ){
            throw new InvalidParamException("参数为空");
        }


        CollectInfo dynamicEventInfo = new CollectInfo();
        BeanUtils.copyProperties(dynamicEventInfo,request);
        boolean flag = collectService.addCollect(request.getAutograph(),dynamicEventInfo);
        result.setData(flag);
        return result;
    }


    @RequestMapping(value ="/getCollect/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<List<DynamicEventDao>> getCollect(@RequestBody QueryBaseRequest request){
        Result<List<DynamicEventDao>> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph())
                ){
            throw new InvalidParamException("参数为空");
        }

        List<CollectInfo> eventInfoList = collectService.getCollect(request.getStart(),request.getSize());
        List<DynamicEventDao> dynamicEventDaoList = new ArrayList<>();
        if(CollectionUtils.isEmpty(eventInfoList)){
            DynamicEventDao dao;
            for(CollectInfo info : eventInfoList){
                dao = new DynamicEventDao();
                BeanUtils.copyProperties(info,dao);
                dynamicEventDaoList.add(dao);
            }
        }
        result.setData(dynamicEventDaoList);
        return result;
    }

    @RequestMapping(value ="/delCollect/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delCollect(@RequestBody DelBaseRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph())
                ){
            throw new InvalidParamException("参数为空");
        }

        boolean flag = collectService.delCollect(request.getAutograph(),request.getId());
        result.setData(flag);
        return result;
    }

}
