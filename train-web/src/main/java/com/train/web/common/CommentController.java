package com.train.web.common;

import com.train.Exception.InvalidParamException;
import com.train.domain.bean.CommentInfo;
import com.train.service.common.CommentService;
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
 * Create Date: 2019/8/19 22:53
 * Description: ${DESCRIPTION}
 */
@RequestMapping("/comment")
@RestController
public class CommentController {

    @Resource
    private CommentService commentService;

    @RequestMapping(value ="/addComment/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> addComment(@RequestBody CommentRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph())
                ){
            throw new InvalidParamException("参数为空");
        }


        CommentInfo dynamicEventInfo = new CommentInfo();
        BeanUtils.copyProperties(dynamicEventInfo,request);
        boolean flag = commentService.addComment(request.getAutograph(),dynamicEventInfo);
        result.setData(flag);
        return result;
    }


    @RequestMapping(value ="/getComment/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<List<DynamicEventDao>> getComment(@RequestBody QueryBaseRequest request){
        Result<List<DynamicEventDao>> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph())
                ){
            throw new InvalidParamException("参数为空");
        }

        List<CommentInfo> eventInfoList = commentService.getComment(request.getStart(),request.getSize());
        List<DynamicEventDao> dynamicEventDaoList = new ArrayList<>();
        if(CollectionUtils.isEmpty(eventInfoList)){
            DynamicEventDao dao;
            for(CommentInfo info : eventInfoList){
                dao = new DynamicEventDao();
                BeanUtils.copyProperties(info,dao);
                dynamicEventDaoList.add(dao);
            }
        }
        result.setData(dynamicEventDaoList);
        return result;
    }

    @RequestMapping(value ="/delComment/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delComment(@RequestBody DelBaseRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph())
                ){
            throw new InvalidParamException("参数为空");
        }

        boolean flag = commentService.delComment(request.getAutograph(),request.getId());
        result.setData(flag);
        return result;
    }

}
