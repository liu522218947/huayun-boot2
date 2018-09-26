package com.huayun.dao;

import com.huayun.model.entity.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TestMapper {
    public List<Test> getAll();
}
