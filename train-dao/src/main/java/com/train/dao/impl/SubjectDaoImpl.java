package com.train.dao.impl;

import com.train.dao.declare.SubjectDao;
import com.train.dao.mapper.SubjectMapper;
import com.train.domain.entity.Subject;
import com.train.domain.entity.SubjectExample;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ma peiliang
 * Create Date: 2019/8/15 19:10
 * Description: ${DESCRIPTION}
 */
@Repository
public class SubjectDaoImpl implements SubjectDao {

    @Resource
    private SubjectMapper subjectMapper;

    @Override
    public List<Subject> getAll() {
        SubjectExample subjectExample = new SubjectExample();


        return  subjectMapper.selectByExample(subjectExample);
    }
}
