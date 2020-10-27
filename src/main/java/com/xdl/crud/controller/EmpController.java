package com.xdl.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xdl.crud.bean.Emp;
import com.xdl.crud.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * If you don't leave me ,I'll by your side untill
 * the life end.
 *
 * @Author zhukangle
 * @Date 2020/10/27
 * @Time 2:58 下午
 */

/**
 * 处理员工CURD请求
 */
@Controller
public class EmpController {
    @Autowired
    EmpService empService;
    /**
     * 查询员工数据，分页查询
     * @return
     */
    @RequestMapping("/emps")
    public  String getEmps(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        //引入PageHelper插件
        //在查询之前只需要调用,传入页码，以及每页的数量
        PageHelper.startPage(pn,5);
        //startPage后面紧跟的这个查询就是分页查询
        List<Emp> emps = empService.getAll();
        //用PageInFo包装查询之后的结果，只需要把PageInfo交给页面
        //封装了详细的分页信息，包括我们查询出来的数据,传入连续显示的数据
        PageInfo page = new PageInfo<>(emps,5);
        model.addAttribute("pageInfo",page);
        System.out.println("哈哈");
        return "list";
    }
}
