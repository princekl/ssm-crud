package com.xdl.crud.controller;

import com.xdl.crud.bean.Dept;
import com.xdl.crud.bean.Msg;
import com.xdl.crud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * If you don't leave me ,I'll by your side untill
 * the life end.
 *
 * @Author zhukangle
 * @Date 2020/10/28
 * @Time 9:59 下午
 */
@Controller
public class DeptController {
    @Autowired
    DeptService deptService;

    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        List<Dept> depts = deptService.getDepts();
        return Msg.success().add("depts",depts);

    }

}
