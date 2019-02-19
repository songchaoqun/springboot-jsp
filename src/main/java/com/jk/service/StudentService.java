package com.jk.service;

import com.jk.dao.StudentDao;
import com.jk.dao.StudentDaoImpl;
import com.jk.mapper.StudentMapper;
import com.jk.model.Student;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;


    @Autowired
    private StudentDaoImpl studentDaoImpl;

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private AmqpTemplate amqpTemplate;


    public void sendUuidFunction(String uuid) {
        amqpTemplate.convertAndSend("A1802",uuid);
    }

    @Transactional
    public void saveStudent(Student stu) {
        studentDao.save(stu);
        System.out.println("stu.getId() = "+stu.getId());
    }

    @Transactional
    public void deleteStudent(Integer id) {
        studentDao.deleteById(id);
    }

    public List<Student> getAllStudent() {
        List<Student> list = studentDao.findAll();
        return list;
    }

    public Student getStudentById(Integer id){
        Student student = studentDaoImpl.getStudent(id);
        return student;
    }

    public List<Student> getStudentList(){
        List<Student> studentList = studentMapper.getStudentList();
        return studentList;
    }
    
    public Student getStudentOneById(Integer id){
        Student student = studentMapper.getStudentOneById(id);
        return student;
    }

    public List<Student> likeName(String name) {

        return studentMapper.likeName(name);
    }
}
