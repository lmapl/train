package com.train.web.common;

import com.train.Exception.InvalidParamException;
import com.train.domain.bean.LoginInfo;
import com.train.domain.bean.RegisterInfo;
import com.train.domain.enums.RegisterTypeEnum;
import com.train.service.common.MobileService;
import com.train.service.common.UserService;
import com.train.web.bean.Result;
import com.train.web.dao.LoginRequest;
import com.train.web.dao.MobileVerifyCodeRequest;
import com.train.web.dao.RegisterRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/24 17:26
 * Description: ${DESCRIPTION}
 */
@RequestMapping("/mobile")
@RestController
public class MobileController {

    @Resource
    private MobileService mobileService;

    @Resource
    private UserService userService;

    @RequestMapping(value ="/mobileVerifyCode",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean>  mobileVerifyCode(@RequestBody MobileVerifyCodeRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getMobile()) || StringUtils.isEmpty(request.getToken()) || StringUtils.isEmpty(request.getUuid())){
            throw new InvalidParamException("参数为空");
        }
        mobileService.getMobileVerifyCode(request.getMobile(),request.getUuid(),request.getToken());
        result.setData(true);
        return result;
    }

    @RequestMapping(value ="/register",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean>  register(@RequestBody RegisterRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getUserName())
                || StringUtils.isEmpty(request.getPassword())
                || StringUtils.isEmpty(request.getUuid())
                || request.getPlatform() == null
                ){
            throw new InvalidParamException("参数为空");
        }

        if(StringUtils.isEmpty(request.getMobileVerifyCode())){
            throw new InvalidParamException("参数为空");
        }

        RegisterInfo registerInfo = new RegisterInfo();
        registerInfo.setType(RegisterTypeEnum.MOBILE.getKey());
        BeanUtils.copyProperties(request,registerInfo);
        result.setData(userService.register(registerInfo));
        return result;
    }

    @RequestMapping(value ="/login",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean>  login(@RequestBody LoginRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getUserName())
                ||( StringUtils.isEmpty(request.getPassword())
                && StringUtils.isEmpty(request.getMobileVerifyCode()))
                || StringUtils.isEmpty(request.getAutograph()) ){
            throw new InvalidParamException("参数为空");
        }

        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setType(RegisterTypeEnum.MOBILE.getKey());
        BeanUtils.copyProperties(request,loginInfo);
        boolean verify =  userService.mobileLoginVerify(loginInfo);

        RegisterInfo registerInfo = new RegisterInfo();
        BeanUtils.copyProperties(request,registerInfo);
        result.setData(false);
        return result;
    }


}
