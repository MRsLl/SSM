package com.atguigu.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class EmployeeDao extends JdbcDaoSupport {
    /*@Autowired
    JdbcTemplate jdbcTemplate;*/
    @Autowired
    public void initDataSource(DataSource dataSource) {
        setDataSource(dataSource);
    }

    public List<Employee> queryAll() {
        String sql = "select `id`,`name`,`salary` from employee";
        List<Employee> list = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
        return list;
    }
}
