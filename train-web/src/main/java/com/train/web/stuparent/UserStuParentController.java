package com.train.web.stuparent;

import com.train.Exception.InvalidParamException;
import com.train.domain.bean.CompanyInfo;
import com.train.domain.bean.ImproveInfo;
import com.train.service.common.CompanyService;
import com.train.service.common.UserService;
import com.train.web.bean.Result;
import com.train.web.dao.BaseRequest;
import com.train.web.dao.HomePage;
import com.train.web.dao.ImproveRequest;
import com.train.web.dao.LabelRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @RequestMapping(value ="/improveInfo/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> improveInfo(@RequestBody ImproveRequest request){
        Result<Boolean> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph()) ){
            throw new InvalidParamException("参数为空");
        }
        ImproveInfo improveInfo = new ImproveInfo();
        BeanUtils.copyProperties(request,improveInfo);
        result.setData(userService.userStuImproveInfo(improveInfo));
        return result;
    }

    @RequestMapping(value ="/homePage/v1",method = RequestMethod.POST)
    @ResponseBody
    public Result<HomePage> homePage(@RequestBody BaseRequest request){
        Result<HomePage> result = new Result<>();
        if(StringUtils.isEmpty(request.getAutograph()) ){
            throw new InvalidParamException("参数为空");
        }
        ImproveInfo improveInfo = new ImproveInfo();
        BeanUtils.copyProperties(request,improveInfo);

        List<CompanyInfo> selectedCompany =companyService.selectedCompany();

        HomePage homePage = new HomePage();
        result.setData(homePage);
        return result;
    }


}
