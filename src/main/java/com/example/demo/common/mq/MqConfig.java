package com.example.demo.common.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {
	@Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }
}
