package com.jk.service;

import com.jk.dao.StudentDao;
import com.jk.model.Student;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public String say(String who, String what) {
        return  who + ":   " +what;
    }

    @Override
    public List<Student> getAllObj() {

        Sort sortx = new Sort(new Sort.Order(Sort.Direction.DESC,"id"));

        return studentDao.findAll(sortx);
    }

    @Autowired
    private AmqpTemplate amqpTemplate;
    @Override
    public void sendUuidFunction(String uuid) {
        amqpTemplate.convertAndSend("A1802",uuid);
    }
}
