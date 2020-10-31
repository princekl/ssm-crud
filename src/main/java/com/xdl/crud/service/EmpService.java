package com.xdl.crud.service;

import com.xdl.crud.bean.Emp;
import com.xdl.crud.bean.EmpExample;
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

    public Emp selectByPrimaryKey(int empId) {
        return empMapper.selectByPrimaryKey(empId);
    }

    public void saveEmp(Emp emp){
        empMapper.insertSelective(emp);
    }

    /**
     *检查用户名是否可用
     * @param empName
     * @return true 可用
     */
    public boolean checkUser(String empName) {
        EmpExample empExample = new EmpExample();
        EmpExample.Criteria criteria = empExample.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        long l = empMapper.countByExample(empExample);
        return l == 0;
    }
    /**
     * 按照员工id查询员工
     * @param id
     * @return
     */
    public Emp getEmp(Integer id) {
        // TODO Auto-generated method stub
        Emp emp = empMapper.selectByPrimaryKey(id);
        return emp;
    }

    /**
     * 员工更新
     * @param emp
     */
    public void updateEmp(Emp emp) {
        // TODO Auto-generated method stub
        empMapper.updateByPrimaryKeySelective(emp);
    }

    /**
     * 员工删除
     * @param id
     */
    public void deleteEmp(Integer id) {
        // TODO Auto-generated method stub
        empMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> ids) {
        // TODO Auto-generated method stub
        EmpExample example = new EmpExample();
        EmpExample.Criteria criteria = example.createCriteria();
        //delete from xxx where emp_id in(1,2,3)
        criteria.andEmpIdIn(ids);
        empMapper.deleteByExample(example);
    }
}
