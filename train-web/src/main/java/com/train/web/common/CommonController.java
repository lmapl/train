package com.train.web.common;

import com.train.Exception.InvalidParamException;
import com.train.domain.bean.SubjectInfo;
import com.train.service.common.OperateService;
import com.train.service.common.TokenService;
import com.train.web.bean.Result;
import com.train.web.dao.BaseRequest;
import com.train.web.dao.DynamicEventRequest;
import com.train.web.dao.SubjectDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/24 17:26
 * Description: ${DESCRIPTION}
 */
@RequestMapping("/common")
@RestController
public class CommonController {

    @Resource
    private TokenService tokenService;

    @Resource
    private OperateService operateService;

    @RequestMapping(value ="/getToken/v1")
    @ResponseBody
    public Result<String> getToken(String type ,String uuid){
        Result<String> result = new Result<>();
        if(StringUtils.isEmpty(uuid) || StringUtils.isEmpty(type)){
            throw new InvalidParamException("参数为空");
        }
        result.setData(tokenService.getServerToken(type,uuid));
        return result;
    }

    @RequestMapping(value ="/getSubject/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<List<SubjectDto>> getSubject(@RequestBody BaseRequest request){
        Result<List<SubjectDto>> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph())){
            throw new InvalidParamException("参数为空");
        }
        List<SubjectInfo> subjectInfoist = operateService.getSubject();
        List<SubjectDto> subjectDtoList = new ArrayList<>();
        SubjectDto subjectDto;
        for(SubjectInfo info :subjectInfoist){
            subjectDto = new SubjectDto();
            BeanUtils.copyProperties(info,subjectDto);
            subjectDtoList.add(subjectDto);
        }

        result.setData(subjectDtoList);
        return result;
    }

    @RequestMapping(value ="/addDynamicEvent/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> addDynamicEvent(@RequestBody DynamicEventRequest request){
        Result<List<SubjectDto>> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph())
                || (StringUtils.isEmpty(request.getCopyWriting()) && StringUtils.isEmpty(request.getViewUrl()))
                || StringUtils.isEmpty(request.getPosition())){
            throw new InvalidParamException("参数为空");
        }



        List<SubjectInfo> subjectInfoist = operateService.getSubject();
        List<SubjectDto> subjectDtoList = new ArrayList<>();
        SubjectDto subjectDto;
        for(SubjectInfo info :subjectInfoist){
            subjectDto = new SubjectDto();
            BeanUtils.copyProperties(info,subjectDto);
            subjectDtoList.add(subjectDto);
        }

        result.setData(subjectDtoList);
        return null;
    }




}
