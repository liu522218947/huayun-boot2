package com.huayun.service;

import com.huayun.dao.TestMapper;
import com.huayun.model.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestServiceImpl implements TestService{
    @Autowired
    TestMapper testMapper;
    @Override
    public List<Test> getAllUser() {
        return testMapper.getAll();
    }
}
