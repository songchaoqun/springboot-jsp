package com.jk.service;

import com.jk.model.Student;

import java.util.List;

public interface TestService {

     String say(String who,String what);

     List<Student> getAllObj();

     void sendUuidFunction(String uuid);
}
