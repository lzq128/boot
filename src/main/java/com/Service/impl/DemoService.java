package com.Service.impl;

import com.Service.IDemoService;
import com.dao.*;
import com.entity.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Transactional
@MapperScan(basePackages="com.dao")
@Service("demoService")
public class DemoService implements IDemoService{

    @Autowired
    private IDemoDao dao;

    @Override
    public List<Demo> selectAll() {
        return dao.selectAll();
    }
}
