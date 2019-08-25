package com.train.web.stuparent;

import com.train.Exception.InvalidParamException;
import com.train.domain.bean.*;
import com.train.domain.enums.LocationEnum;
import com.train.service.common.CompanyService;
import com.train.service.common.OperateService;
import com.train.service.common.UserService;
import com.train.web.bean.Result;
import com.train.web.dao.*;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/2 16:38
 * Description: ${DESCRIPTION}
 */
@RequestMapping("/stuParent")
@RestController
public class UserStuParentController {

    @Resource
    private UserService userService;

    @Resource
    private CompanyService companyService;

    @Resource
    private OperateService operateService;


    @RequestMapping(value ="/improveInfo/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> improveInfo(@RequestBody UserStuParentRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph()) ){
            throw new InvalidParamException("参数为空");
        }
        UserStuParentInfo improveInfo = new UserStuParentInfo();
        BeanUtils.copyProperties(request,improveInfo);
        result.setData(userService.userStuImproveInfo(request.getAutograph(),improveInfo));
        return result;
    }

    @RequestMapping(value ="/homePage/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<HomePage> homePage(@RequestBody BaseRequest request){
        Result<HomePage> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph()) ){
            throw new InvalidParamException("参数为空");
        }

        int location = LocationEnum.USER_STU_PARENT_HOME.getKey();

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
        List<CompanyInfo> selectedCompany =operateService.getSelectedCompanyByLocation(location);
        List<CompanyDto> selectedCompanyDtoList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(selectedCompany)){
            CompanyDto dto ;
            for(CompanyInfo companyInfo : selectedCompany){
                dto = new CompanyDto();
                BeanUtils.copyProperties(companyInfo,dto);
                selectedCompanyDtoList.add(dto);
            }
        }

        //普通机构
        List<CompanyInfo> normalCompany =companyService.getCompanyInfo(1,10);
        List<CompanyDto> normalCompanyDtoList = new ArrayList<>();

        if(!CollectionUtils.isEmpty(normalCompany)){
            CompanyDto dto;
            for(CompanyInfo companyInfo : normalCompany){
                dto = new CompanyDto();
                BeanUtils.copyProperties(companyInfo,dto);
                normalCompanyDtoList.add(dto);
            }
        }

        HomePage homePage = new HomePage();
        homePage.setRecommend(recommendDto);
        homePage.setRotationShow(rotationShow);
        homePage.setSelectedCompany(selectedCompanyDtoList);
        homePage.setNormalCompany(normalCompanyDtoList);
        result.setData(homePage);
        return result;
    }


}
