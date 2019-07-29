package com.train.web.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/24 17:26
 * Description: ${DESCRIPTION}
 */
@RequestMapping("/common")
@RestController
public class CommonController {

    @RequestMapping(value ="/getToken",method = RequestMethod.POST)
    @ResponseBody
    public String testMode(String uuid){
        System.out.println(System.currentTimeMillis());
        //demoService.fo();
        return "aaa";
    }
}
