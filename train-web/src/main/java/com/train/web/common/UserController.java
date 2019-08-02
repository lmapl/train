package com.train.web.common;

import com.train.Exception.InvalidParamException;
import com.train.domain.bean.LoginInfo;
import com.train.domain.bean.RegisterInfo;
import com.train.domain.entity.User;
import com.train.domain.enums.RegisterTypeEnum;
import com.train.service.common.MobileService;
import com.train.service.common.UserService;
import com.train.web.bean.Result;
import com.train.web.dao.*;
import org.springframework.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/24 17:26
 * Description: ${DESCRIPTION}
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    private MobileService mobileService;

    @Resource
    private UserService userService;

    @RequestMapping(value ="/mobileVerifyCode/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean>  mobileVerifyCode(@RequestBody MobileVerifyCodeRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getMobile()) || StringUtils.isEmpty(request.getToken())){
            throw new InvalidParamException("参数为空");
        }
        mobileService.getMobileVerifyCode(request.getMobile(),request.getUuid(),request.getToken());
        result.setData(true);
        return result;
    }

    @RequestMapping(value ="/mobileRegister/v1",method = RequestMethod.POST)
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

    @RequestMapping(value ="/mobileLogin/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<LoginResponse>  login(@RequestBody LoginRequest request){
        Result<LoginResponse> result = new Result<>();
        if(StringUtils.isEmpty(request.getUserName())
                ||( StringUtils.isEmpty(request.getPassword())
                && StringUtils.isEmpty(request.getMobileVerifyCode()))
                || StringUtils.isEmpty(request.getAutograph()) ){
            throw new InvalidParamException("参数为空");
        }

        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setType(RegisterTypeEnum.MOBILE.getKey());
        BeanUtils.copyProperties(request,loginInfo);
        User user =  userService.mobileLoginVerify(loginInfo);
        if(user == null){
            result.setSuccess(false);
            return result;
        }
        String auth = userService.login(user);

        LoginResponse response = new LoginResponse();
        response.setAutograph(auth);
        response.setEducateLevel(user.getEducateLevel());
        response.setUserType(user.getUserType());
        response.setGrade(user.getGrade());
        result.setData(response);
        return result;
    }

    @RequestMapping(value ="/loginOut/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean>  loginOut(@RequestBody LoginOutRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph()) ){
            throw new InvalidParamException("参数为空");
        }
        result.setData(userService.loginOut(request.getAutograph()));
        return result;
    }

    @RequestMapping(value ="/bindMobile/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean>  bindMobile(@RequestBody BindRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph())
                || StringUtils.isEmpty(request.getMobile())
                || StringUtils.isEmpty(request.getMobileVerifyCode()) ){
            throw new InvalidParamException("参数为空");
        }
        result.setData(userService.bindMobile(request.getAutograph(),request.getMobile(),request.getMobileVerifyCode()));
        return result;
    }

    @RequestMapping(value ="/identityConfirm/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean>  identityConfirm(@RequestBody IdentityRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph())
                || request.getType() == null  ){
            throw new InvalidParamException("参数为空");
        }
        result.setData(userService.userTypeConfirm(request.getAutograph(),request.getType()));
        return result;
    }

    @RequestMapping(value ="/labelConfirm/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean>  labelConfirm(@RequestBody LabelRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph())
                || request.getEducateLevel() == null
                || request.getGrade() == null){
            throw new InvalidParamException("参数为空");
        }
        result.setData(userService.labelConfirm(request.getAutograph(),request.getEducateLevel(),request.getGrade()));
        return result;
    }


}
