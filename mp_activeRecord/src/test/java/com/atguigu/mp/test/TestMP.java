package com.atguigu.mp.test;

import com.atguigu.mp.beans.Employee;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestMP {
    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    /**
     * AR  分页复杂操作
     */
    @Test
    public void testARPage() {

        Employee employee = new Employee();
        Page<Employee> page = employee.selectPage(new Page<>(1, 3),
                new EntityWrapper<Employee>().like("last_name", "老"));
        List<Employee> emps = page.getRecords();
        System.out.println(emps);
    }


    /**
     * AR 删除操作
     * <p>
     * 注意: 删除不存在的数据 逻辑上也是属于成功的.
     */
    @Test
    public void testARDelete() {
        Employee employee = new Employee();
        boolean result = employee.delete(new EntityWrapper<Employee>().like("last_name", "湿"));
        System.out.println(result);
    }

    @Test
    public void testARDelete2() {
        Employee employee = new Employee();
        employee.setId(16);
        boolean result = employee.deleteById();
        System.out.println("result:" + result);
    }

    @Test
    public void testARDelete1() {
        Employee employee = new Employee();
        boolean result = employee.deleteById(15);
        System.out.println(result);
    }


    /**
     * AR 查询操作
     */
    @Test
    public void testARSelect4() {
        Employee employee = new Employee();
        Integer result = employee.selectCount(new EntityWrapper<Employee>().eq("gender", 0));
        System.out.println("result: " + result);
    }

    @Test
    public void testARSelect3() {
        Employee employee = new Employee();
        List<Employee> emps =
                employee.selectList(new EntityWrapper<Employee>().like("last_name", "老师"));
        System.out.println(emps);
    }

    @Test
    public void testARSelect2() {
        Employee employee = new Employee();
        List<Employee> emps = employee.selectAll();
        System.out.println(emps.size());
    }

    @Test
    public void testARSelect1() {
        Employee employee = new Employee();

        Employee result = employee.selectById(14);
        System.out.println(result);
        employee.setId(15);
        result = employee.selectById();
        System.out.println(result);

    }


    /**
     * AR 修改操作
     */
    @Test
    public void testARUpdate() {
        Employee employee = new Employee();
        employee.setId(17);
        employee.setLastName("宋老湿");
        employee.setEmail("sls@atguigu.com");
        employee.setGender(1);
        employee.setAge(36);


        boolean result = employee.updateById();
        System.out.println("result:" + result);

    }


    /**
     * AR  插入操作
     */
    @Test
    public void testARInsert() {
        Employee employee = new Employee();
        employee.setLastName("宋老师");
        employee.setEmail("sls@atguigu.com");
        employee.setGender(1);
        employee.setAge(35);

        boolean result = employee.insert();
        System.out.println("result:" + result);
    }

}
