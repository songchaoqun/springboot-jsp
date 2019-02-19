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


import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//@RestController
@Controller
public class UserController {
    @Value("${id}")
    private Integer id;
    @Autowired
    private StudentService studentService;
    @Autowired
    private AmqpTemplate amqpTemplate;

    ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

//    @RequestMapping(value = {"/to","/index"}, method = RequestMethod.GET)
//    @GetMapping("toIndex")
//    @PostMapping()
    @RequestMapping(value = "/index/{id}/{age}", method = RequestMethod.GET)
    public String toIndex(@PathVariable Integer id,@PathVariable Integer age) {
//    @RequestMapping("/index")
//    public String toIndex(@RequestParam Integer id) {
         return "Hello World!!="+id+"--,--age="+age;
    }

    @RequestMapping("/boot")
    @ResponseBody
    public Student toIndex() {
        Student s = new Student();
        s.setAge(18);
        s.setId(15);
        s.setCreateTime(new Date());
        amqpTemplate.convertAndSend("A1802","李晓明很帅！");


        return s;
    }
    @Autowired
    private TestService testService;
    @RequestMapping("/getUserIdQj")
    public String getUserIdQj(HttpServletRequest req){
        req.setAttribute("username","xiaowang");
/*
        List <Student> list = testService.getAllObj();
*/
        /*for(Student stu : list){
            System.out.println(stu.getId());
        }*/
        System.out.println("list========"+1/0);
        return "";
    }


    @RequestMapping("/massage")
    @ResponseBody
    public String getMassage() {
        return "abcd11w2312342wqasdasd123";
    }
    @RequestMapping("/massage1")
    @ResponseBody
    public String getMassage2() {
        return "abcdrefasdadasd";
    }
    @RequestMapping("/massage2")
    @ResponseBody
    public String getMassage1() {
        return "asdaasdasd";
    }


    @RequestMapping("/body")
    @ResponseBody
    public String toBody() {
        String uuid = UUID.randomUUID().toString();
        singleThreadExecutor.execute(new TestThread(studentService,uuid));
        return "";
    }
    @RequestMapping("/save")
    @ResponseBody
    public void saveStudent() {
        Student stu = new Student();
        stu.setAge(333);
        stu.setCreateTime(new Date());
        studentService.saveStudent(stu);
    }




    @RequestMapping("/delete")
    @ResponseBody
    public void deleteStudent() {
        Integer id = 1;
        studentService.deleteStudent(id);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public  List<Student> getAllStudent() {
        List<Student> list =  studentService.getAllStudent();
        return list;
    }
    @RequestMapping("/getStu")
    @ResponseBody
    public  Student getStudentById() {
        Student  stu=  studentService.getStudentById(1);
        return stu;
    }

    @RequestMapping("/toHtml")
    public  String toHtml() {

        return "index";
    }

    @RequestMapping("/getList")
    @ResponseBody
    public   List<Student> getStudentList() {
        List<Student> studentList = studentService.getStudentList();
        return studentList;
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public   Student getStudentOneById(@RequestParam Integer id) {
        Student one = studentService.getStudentOneById(id);
        return one;
    }
    @RequestMapping("/likeName/{name}")
    @ResponseBody
    public List<Student> likeName(@PathVariable String name){
        System.out.println("name="+name);
        PageHelper.startPage(1,1);
        return studentService.likeName(name);
    }

}
