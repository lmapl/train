package com.train.web.company;

import com.train.Exception.InvalidParamException;
import com.train.dao.declare.CompanyTeacherDao;
import com.train.domain.bean.*;
import com.train.domain.enums.LocationEnum;
import com.train.service.common.CompanyService;
import com.train.service.common.OperateService;
import com.train.service.common.UserService;
import com.train.service.teacher.TeacherService;
import com.train.web.bean.Result;
import com.train.web.dao.*;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RequestMapping("/company")
@RestController
public class CompanyController {

    @Resource
    private UserService userService;

    @Resource
    private CompanyService companyService;

    @Resource
    private OperateService operateService;

    @Resource
    private TeacherService teacherService;

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

    @RequestMapping(value ="/addCurriculum/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> addCurriculum(@RequestBody AddCurriculumRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph()) ){
            throw new InvalidParamException("参数为空");
        }
        CompanyCurriculumInfo info = new CompanyCurriculumInfo();
        BeanUtils.copyProperties(request,info);
        result.setData(companyService.addCurriculum(request.getAutograph(),info));
        return result;
    }

    @RequestMapping(value ="/getCompanyDetailDto/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<CompanyDto> getCompanyDetailDto(@RequestBody CompanyRequest request){
        Result<CompanyDto> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph()) || request.getId() == null ){
            throw new InvalidParamException("参数为空");
        }
        CompanyCurriculumInfo info = new CompanyCurriculumInfo();
        BeanUtils.copyProperties(request,info);
        CompanyInfo companyInfo =  companyService.getCompanyDetailDto(request.getId());
        CompanyDto companyDto = new CompanyDto();
        BeanUtils.copyProperties(companyInfo,companyDto);
        result.setData(companyDto);
        return result;
    }

    @RequestMapping(value ="/homePage/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<CompanyHomePage> homePage(@RequestBody BaseRequest request){
        Result<CompanyHomePage> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph()) ){
            throw new InvalidParamException("参数为空");
        }

        int location = LocationEnum.Company_HOME.getKey();

        //轮播图
        List<RotationShowDto> rotationShow = new ArrayList<>();
        List<RotationShowInfo> showInfoList = operateService.getRotationShowByLocation(location);
        RotationShowDto rotationShowDto;
        for(RotationShowInfo info : showInfoList ){
            rotationShowDto = new RotationShowDto();
            BeanUtils.copyProperties(info,rotationShowDto);
            rotationShow.add(rotationShowDto);
        }

        //推荐内容
        RecommendDto recommendDto = null;
        List<OperateRecommendInfo> recommend = operateService.getRecommendByLocation(location);
        if(!CollectionUtils.isEmpty(recommend)){
            recommendDto = new RecommendDto();
            BeanUtils.copyProperties(recommend.get(0),recommendDto);
        }

        //精选机构
        List<TeacherInfo> selectedTeacher =operateService.getSelectedTeacherByLocation(location);
        List<TeacherDto> selectedTeacherDtoList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(selectedTeacherDtoList)){
            TeacherDto dto ;
            for(TeacherInfo teacherInfo : selectedTeacher){
                dto = new TeacherDto();
                BeanUtils.copyProperties(teacherInfo,dto);
                selectedTeacherDtoList.add(dto);
            }
        }

        //普通机构
        List<TeacherInfo> normalTeacher = teacherService.getTeacherList(1,10);
        List<TeacherDto> normalTeacherDtoList = new ArrayList<>();

        if(!CollectionUtils.isEmpty(normalTeacher)){
            TeacherDto dto;
            for(TeacherInfo companyInfo : normalTeacher){
                dto = new TeacherDto();
                BeanUtils.copyProperties(companyInfo,dto);
                normalTeacherDtoList.add(dto);
            }
        }

        CompanyHomePage homePage = new CompanyHomePage();
        homePage.setRecommend(recommendDto);
        homePage.setRotationShow(rotationShow);
        homePage.setSelectedTeacherDto(selectedTeacherDtoList);
        homePage.setNormalTeacherDto(normalTeacherDtoList);
        result.setData(homePage);
        return result;
    }

    @RequestMapping(value ="/getCompanyTeacherList/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<List<CompanyTeacherDto>> getCompanyTeacherList(@RequestBody CompanyRequest request){
        Result<List<CompanyTeacherDto>> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph()) || request.getId() == null ){
            throw new InvalidParamException("参数为空");
        }
        CompanyCurriculumInfo info = new CompanyCurriculumInfo();
        BeanUtils.copyProperties(request,info);
        List<CompanyTeacherInfo > companyInfoList =  companyService.getCompanyTeacherList(request.getId(),request.getStart());
        CompanyTeacherDto companyDto;
        List<CompanyTeacherDto> companyTeacherDtos = new ArrayList<>();
        for(CompanyTeacherInfo companyInfo : companyInfoList){
            companyDto = new CompanyTeacherDto();
            BeanUtils.copyProperties(companyInfo,companyDto);
            companyTeacherDtos.add(companyDto);
        }
        result.setData(companyTeacherDtos);
        return result;
    }

    @RequestMapping(value = "/getCompanyTeacher/v1", method = RequestMethod.POST)
    @ResponseBody
    public Result<TeacherDto> getCompanyTeacher(@RequestBody UserTeacherRequest request) {
        Result<TeacherDto> result = new Result<>();
        if (StringUtils.isEmpty(request.getAutograph()) || request.getId() == null) {
            throw new InvalidParamException("参数为空");
        }
        ImproveInfo improveInfo = new ImproveInfo();
        BeanUtils.copyProperties(request, improveInfo);
        TeacherInfo teacherInfo = teacherService.getTeacherInfo(request.getId());
        TeacherDto teacherDto = new TeacherDto();
        BeanUtils.copyProperties(teacherInfo, teacherDto);
        result.setData(teacherDto);
        return result;
    }

}
