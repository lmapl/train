package com.train.web.teacher;

import com.train.Exception.InvalidParamException;
import com.train.domain.bean.TeacherInfo;
import com.train.domain.bean.UserCompanyInfo;
import com.train.domain.bean.UserTeacherInfo;
import com.train.service.common.UserService;
import com.train.service.teacher.TeacherService;
import com.train.web.bean.Result;
import com.train.web.dao.CompanyRequest;
import com.train.web.dao.TeacherDto;
import com.train.web.dao.UserTeacherRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RequestMapping("/teacher")
@RestController
public class UserTeacherController {

    @Resource
    private TeacherService teacherService;

    @Resource
    private UserService userService;

    @RequestMapping(value = "/improveInfo/v1", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> improveInfo(@RequestBody UserTeacherRequest request) {
        Result<Boolean> result = new Result<>();
        if (StringUtils.isEmpty(request.getAutograph())) {
            throw new InvalidParamException("参数为空");
        }
        UserTeacherInfo improveInfo = new UserTeacherInfo();
        BeanUtils.copyProperties(request, improveInfo);
        result.setData(userService.teacherImproveInfo(request.getAutograph(),improveInfo));
        return result;
    }


    @RequestMapping(value = "/getTeacher/v1", method = RequestMethod.POST)
    @ResponseBody
    public Result<TeacherDto> getTeacher(@RequestBody CompanyRequest request) {
        Result<TeacherDto> result = new Result<>();
        if (StringUtils.isEmpty(request.getAutograph()) || request.getId() == null) {
            throw new InvalidParamException("参数为空");
        }
        UserCompanyInfo improveInfo = new UserCompanyInfo();
        BeanUtils.copyProperties(request, improveInfo);
        TeacherInfo teacherInfo = teacherService.getTeacherInfo(request.getId());
        TeacherDto teacherDto = new TeacherDto();
        BeanUtils.copyProperties(teacherInfo, teacherDto);
        result.setData(teacherDto);
        return result;
    }


}
