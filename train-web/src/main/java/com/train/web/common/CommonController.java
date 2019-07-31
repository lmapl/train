package com.train.web.common;

import com.train.Exception.InvalidParamException;
import com.train.domain.bean.RegisterInfo;
import com.train.service.common.MobileService;
import com.train.service.common.TokenService;
import com.train.service.common.UserService;
import com.train.web.bean.Result;
import com.train.web.dao.MobileVerifyCodeRequest;
import com.train.web.dao.RegisterRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
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

    @Resource
    private UserService userService;

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
