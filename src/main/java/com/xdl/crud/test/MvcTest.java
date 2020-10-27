package com.xdl.crud.test;

/**
 * If you don't leave me ,I'll by your side untill
 * the life end.
 *
 * @Author zhukangle
 * @Date 2020/10/27
 * @Time 3:31 下午
 * <p>
 * 使用Spring测试模块提供的测试请求功能，测试crud的正确性
 */

/**
 * 使用Spring测试模块提供的测试请求功能，测试crud的正确性
 */

import com.github.pagehelper.PageInfo;
import com.xdl.crud.bean.Emp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml","file:/Users/zhukangle/IdeaProjects/ssm-crud/src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class MvcTest {
    //传入Springmvc的ioc
    @Autowired
    WebApplicationContext context;
    MockMvc mockMvc;
    @Before
    public void initMockMvc() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }
    @Test
    public void testPage() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/emps")
                        .param("pn", "1"))
                .andReturn();
        //请求成功以后，请求域中会有pageInfo，可以取出pageInfo进行验证
        MockHttpServletRequest request = result.getRequest();
        PageInfo pi = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码:"+pi.getPageNum());
        System.out.println("总页码:"+pi.getPages());
        System.out.println("总记录数:"+pi.getTotal());
        System.out.println("在页面需要连续显示的页码:");
        int[] nums = pi.getNavigatepageNums();
        for (int i :
                nums) {
            System.out.println(" "+i);

        }
        //获取员工数据
        List<Emp> list = pi.getList();
        for (Emp emp :
                list) {
            System.out.println("ID:"+emp.getEmpId()+"==>Name"+emp.getEmpName());
        }
    }
}
