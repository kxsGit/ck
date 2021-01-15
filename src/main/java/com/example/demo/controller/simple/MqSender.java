package com.example.demo.controller.simple;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqSender {
	@Autowired
    private AmqpTemplate amqpTemplate;
 
    public void send() {
            String context = "hello开心 ";
            System.out.println("sender我就是创建者: " + context);
            this.amqpTemplate.convertAndSend("hello",context);
    }
}
