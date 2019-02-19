package com.jk.mapper;

import com.jk.model.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    @Select("select * from student ")
    List<Student> getStudentList();

    @Select("select * from student where id = #{id}")
    Student getStudentOneById(Integer id);
   // like 查询使用CONCAT 拼接字符串
    @Select("select * from student where age like CONCAT('%',#{name},'%')")
    List<Student> likeName(String name);
}
