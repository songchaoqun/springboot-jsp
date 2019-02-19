package com.jk.config;

import com.jk.service.StudentService;


public class TestThread implements Runnable{
    private StudentService testService;
    private String uuid;

    public TestThread(StudentService testService, String uuid) {
         this.testService = testService;
         this.uuid = uuid;
    }

    @Override
    public void run() {
        testService.sendUuidFunction(uuid);
    }

    public TestThread() {
    }
}
