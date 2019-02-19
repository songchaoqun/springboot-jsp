package com.jk.config;


import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "B1804")
public class GetRabbitMqData {
    @RabbitHandler
    public void proess(String msg){
        System.out.println("say:"+msg);
    }
}
