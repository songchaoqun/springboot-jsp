package com.jk.controller;

import com.github.pagehelper.PageHelper;
import com.jk.config.TestThread;
import com.jk.model.Student;
import com.jk.service.StudentService;
import com.jk.service.TestService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//@RestController
@Controller
@RequestMapping("/student")
public class StuController {

    @RequestMapping("add")
    public void add(){

    }
    @RequestMapping("/student/del")
    public void del(){

    }
    @RequestMapping("/student/up")
    public void up(){

    }
//     /student/add

    @RequestMapping("/student/addTeacher")
   public void addTeacher(){

   }







}
