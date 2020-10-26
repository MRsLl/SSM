package com.atguigu.test;

import com.atguigu.pojo.Employee;
import com.atguigu.pojo.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class jdbcTempleTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test() throws SQLException {
        System.out.println(dataSource.getConnection());
        System.out.println(jdbcTemplate);
    }

    @Test
    public void test2() {
        String sql = "update employee set salary = ? where id = ?";
        jdbcTemplate.update(sql, new BigDecimal("1300.00"), 5);
    }

    @Test
    public void test3() {
        String sql = "insert into employee(`name`,`salary`) values(?,?)";
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"字母哥", new BigDecimal("15000")});
        list.add(new Object[]{"东契尼", new BigDecimal("22000")});
        list.add(new Object[]{"约基奇", new BigDecimal("18000")});

        jdbcTemplate.batchUpdate(sql, list);
    }

    @Test
    public void test4() {
        String sql = "select `id`,`name`,`salary` from employee where id = ?";
        Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class), 5);
        System.out.println(employee);
    }

    @Test
    public void test5() {
        String sql = "select `id`,`name`,`salary` from employee where salary > ?";
        List<Employee> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class), 5000);
        for (Employee employee : list) {
            System.out.println(employee);
        }

    }

    @Test
    public void test6() {
        String sql = "select max(salary) from employee";
        BigDecimal bigDecimal = jdbcTemplate.queryForObject(sql, BigDecimal.class);
        System.out.println(bigDecimal);
    }

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //    实验7：使用带有具名参数的SQL语句插入一条员工记录，并以Map形式传入参数值
    @Test
    public void test7() {
        String sql = "insert into employee(`name`,`salary`) values(:name,:salary)";
        Map<String, Object> map = new HashMap<>();

        map.put("name", "傻狗金");
        map.put("salary", new BigDecimal(100));
        map.put("name", "大磊哥");
        map.put("salary", new BigDecimal(30000));

        namedParameterJdbcTemplate.update(sql, map);
    }


    //    实验8：重复实验7，以SqlParameterSource形式传入参数值
    @Test
    public void test8() {
        String sql = "insert into employee(`name`,`salary`) values(:name,:salary)";

        Employee employee = new Employee(null, "小金子", new BigDecimal("00000"));
        namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(employee));
    }

    //    实验9：创建Dao，自动装配JdbcTemplate对象
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void test9() {
        List<Employee> employees = employeeDao.queryAll();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
