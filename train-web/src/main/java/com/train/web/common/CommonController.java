package com.train.web.common;

import com.train.Exception.InvalidParamException;
import com.train.service.common.MobileService;
import com.train.service.common.TokenService;
import com.train.web.bean.Result;
import com.train.web.dao.MobileVerifyCodeRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    private MobileService mobileService;

    @RequestMapping(value ="/getToken")
    @ResponseBody
    public Result<String> testMode(String type ,String uuid){
        Result<String> result = new Result<>();
        if(StringUtils.isEmpty(uuid) || StringUtils.isEmpty(type)){
            throw new InvalidParamException("参数为空");
        }
        result.setData(tokenService.getServerToken(type,uuid));
        return result;
    }

    @RequestMapping(value ="/mobileVerifyCode",method = RequestMethod.POST)
    @ResponseBody
    public Result<Void>  mobileVerifyCode(@RequestBody MobileVerifyCodeRequest request){
        Result<Void> result = new Result<>();
        if(StringUtils.isEmpty(request.getMobile()) || StringUtils.isEmpty(request.getToken()) || StringUtils.isEmpty(request.getUuid())){
            throw new InvalidParamException("参数为空");
        }
        mobileService.getMobileVerifyCode(request.getMobile(),request.getUuid(),request.getToken());
        return result;
    }


}
