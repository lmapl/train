package com.train.web.company;

import com.train.Exception.InvalidParamException;
import com.train.domain.bean.CompanyTeacherInfo;
import com.train.domain.bean.ImproveInfo;
import com.train.service.common.CompanyService;
import com.train.service.common.UserService;
import com.train.web.bean.Result;
import com.train.web.dao.AddTeacherRequest;
import com.train.web.dao.ImproveRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RequestMapping("/company")
@RestController
public class CompanyController {

    @Resource
    private UserService userService;

    @Resource
    private CompanyService companyService;

    @RequestMapping(value ="/improveInfo/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> improveInfo(@RequestBody ImproveRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph()) ){
            throw new InvalidParamException("参数为空");
        }
        ImproveInfo improveInfo = new ImproveInfo();
        BeanUtils.copyProperties(request,improveInfo);
        result.setData(userService.companyImproveInfo(improveInfo));
        return result;
    }

    @RequestMapping(value ="/addTeacher/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> addTeacher(@RequestBody AddTeacherRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph()) ){
            throw new InvalidParamException("参数为空");
        }
        CompanyTeacherInfo teacherInfo = new CompanyTeacherInfo();
        BeanUtils.copyProperties(request,teacherInfo);
        result.setData(companyService.addTeacher(request.getAutograph(),teacherInfo));
        return result;
    }

    @RequestMapping(value ="/modifyTeacher/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> modifyTeacher(@RequestBody AddTeacherRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph()) ){
            throw new InvalidParamException("参数为空");
        }
        CompanyTeacherInfo teacherInfo = new CompanyTeacherInfo();
        BeanUtils.copyProperties(request,teacherInfo);
        result.setData(companyService.modifyTeacher(request.getAutograph(),teacherInfo));
        return result;
    }

}
