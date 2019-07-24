package com.train.service.demo.impl;

import com.train.dao.demo.DemoDao;
import com.train.service.demo.DemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/24 17:39
 * Description: ${DESCRIPTION}
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    private DemoDao demoDao;

    @Override
    public void fo() {
        System.out.println("bbb");
        demoDao.fo();
    }
}
