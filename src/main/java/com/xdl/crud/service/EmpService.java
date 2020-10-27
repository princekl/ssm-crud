package com.xdl.crud.service;

import com.xdl.crud.bean.Emp;
import com.xdl.crud.dao.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * If you don't leave me ,I'll by your side untill
 * the life end.
 *
 * @Author zhukangle
 * @Date 2020/10/27
 * @Time 3:01 下午
 */
@Service
public class EmpService {
    @Autowired
    EmpMapper empMapper;
    public List<Emp> getAll(){
        return empMapper.selectByExampleWithDept(null);
    }
}
