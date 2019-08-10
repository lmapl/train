package com.train.web.common;

import com.train.Exception.InvalidParamException;
import com.train.domain.bean.AreaInfo;
import com.train.service.common.AreaService;
import com.train.service.common.TokenService;
import com.train.web.bean.Result;
import com.train.web.dao.AreaDto;
import com.train.web.dao.AreaRequest;
import com.train.web.dao.MobileVerifyCodeRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/24 17:26
 * Description: ${DESCRIPTION}
 */
@RequestMapping("/area")
@RestController
public class AreaController {

    @Resource
    private AreaService areaService;

    @RequestMapping(value ="/getArea/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<List<AreaDto>> getArea(@RequestBody AreaRequest request){
        Result<List<AreaDto>> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph()) || request.getScope() == null){
            throw new InvalidParamException("参数为空");
        }
        List<AreaInfo> areaInfoList = areaService.getArea(request.getScope());

        List<AreaDto> areaDtos = new ArrayList<>();
        result.setData(areaDtos);
        return null;
    }

    private List<AreaDto> covert(List<AreaInfo> areaInfoList){
        if(CollectionUtils.isEmpty(areaInfoList)){
            return null;
        }

        AreaDto areaDto;
        List<AreaDto> areaDtoList = new ArrayList<>();
        for(AreaInfo info :areaInfoList){
            areaDto = new AreaDto();
            areaDto.setId(info.getId());
            areaDto.setChildAreaList(covert(info.getChildAreaList()));
            areaDtoList.add(areaDto);
        }
        return areaDtoList;

    }

}
