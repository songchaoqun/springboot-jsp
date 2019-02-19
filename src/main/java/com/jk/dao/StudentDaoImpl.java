package com.jk.dao;

import com.jk.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Student getStudent(Integer id) {
        String sql = "select *from Student where id=?";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
//        String sql1 = "select *from Student where id="+id;
//        jdbcTemplate.queryForObject(sql1,Student.class);
//        jdbcTemplate.execute(sql);
        return jdbcTemplate.queryForObject(sql, rowMapper,id);
    }

}
