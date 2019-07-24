package com.train.service.teacher.impl;

import com.train.dao.demo.DemoDao;
import com.train.service.teacher.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ma peiliang
 * Create Date: 2019/7/24 17:39
 * Description: ${DESCRIPTION}
 */
@Service
public class TeacherImpl implements TeacherService {

    @Resource
    private DemoDao teacherDao;

    @Override
    public void fo() {
        System.out.println("bbb");
        teacherDao.fo();
    }
}
