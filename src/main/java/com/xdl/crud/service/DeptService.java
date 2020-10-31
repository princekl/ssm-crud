package com.xdl.crud.service;

import com.xdl.crud.bean.Dept;
import com.xdl.crud.dao.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * If you don't leave me ,I'll by your side untill
 * the life end.
 *
 * @Author zhukangle
 * @Date 2020/10/28
 * @Time 9:59 下午
 */
@Service
public class DeptService {
    @Autowired
    DeptMapper deptMapper;
    public List<Dept> getDepts(){
        return deptMapper.selectByExample(null);
    }
}
