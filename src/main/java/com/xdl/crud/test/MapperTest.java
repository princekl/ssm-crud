package com.xdl.crud.test;

import com.xdl.crud.bean.Dept;
import com.xdl.crud.bean.Emp;
import com.xdl.crud.dao.DeptMapper;
import com.xdl.crud.dao.EmpMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * If you don't leave me ,I'll by your side untill
 * the life end.
 *
 * @Author zhukangle
 * @Date 2020/10/27
 * @Time 1:16 上午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DeptMapper deptMapper;
    @Autowired
    EmpMapper empMapper;
    @Autowired
    SqlSession sqlSession;
    /**
     * 测试deptmapper
     */
    @Test
    public void testCRUD(){
//        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        DeptMapper bean = ioc.getBean(DeptMapper.class);
        //System.out.println(deptMapper);
        //1.插入几个部门
        //deptMapper.insertSelective(new Dept(null,"开发部"));
        //deptMapper.insertSelective(new Dept(null,"测试部"));
        //2.插入员工数据
       // empMapper.insertSelective(new Emp(null,"Tom","M","Tom@qq.com",1));
        //3.批量插入多个员工；使用可以执行批量操作的SQLSession
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        for (int i = 0; i < 1000; i++) {
            String uid = UUID
                    .randomUUID()
                    .toString()
                    .substring(0, 5);
            mapper.insertSelective(new Emp(null,uid,"M",uid+"@qq.com",1));
        }
        System.out.println("批量完成！");

    }
}
