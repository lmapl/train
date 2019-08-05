package com.train.web.teacher;

import com.train.Exception.InvalidParamException;
import com.train.domain.bean.ImproveInfo;
import com.train.service.common.UserService;
import com.train.web.bean.Result;
import com.train.web.dao.ImproveRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RequestMapping("/teacher")
@RestController
public class UserTeacherController {

    @Resource
    private UserService userService;

    @RequestMapping(value ="/improveInfo/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> improveInfo(@RequestBody ImproveRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph()) ){
            throw new InvalidParamException("参数为空");
        }
        ImproveInfo improveInfo = new ImproveInfo();
        BeanUtils.copyProperties(request,improveInfo);
        result.setData(userService.teacherImproveInfo(improveInfo));
        return result;
    }

}
