package com.train.test.service;

/**
 * Created by machanghai
 * Create Date: 2018/10/27 16:01
 * Description: ${DESCRIPTION}
 */

import com.train.service.common.RedisService;
import com.train.service.common.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by machanghai
 * Create Date: 2018/10/27 10:36
 * Description: 全局配置测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/conf/applicationContext.xml"})
public class UserServiceTest {

    @Resource
    private UserService userService;

    /**
     * 关联任务到场景test
     */
    @Test
    public void set(){
        boolean result = userService.userTypeDetail(6,3);
        System.out.println();
    }
}