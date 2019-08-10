package com.train.web.common;

import com.train.Exception.InvalidParamException;
import com.train.service.common.TokenService;
import com.train.web.bean.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @RequestMapping(value ="/getToken")
    @ResponseBody
    public Result<String> getToken(String type ,String uuid){
        Result<String> result = new Result<>();
        if(StringUtils.isEmpty(uuid) || StringUtils.isEmpty(type)){
            throw new InvalidParamException("参数为空");
        }
        result.setData(tokenService.getServerToken(type,uuid));
        return result;
    }

}
