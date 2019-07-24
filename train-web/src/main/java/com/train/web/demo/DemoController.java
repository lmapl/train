package com.train.web.demo;

import com.train.service.demo.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RequestMapping("/demo")
@RestController
public class DemoController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private DemoService demoService;

    @RequestMapping("/demo")
    @ResponseBody
    public String testMode(HttpServletRequest request, HttpServletResponse response){
        System.out.println(System.currentTimeMillis());
        demoService.fo();
        return "aaa";
    }



}
