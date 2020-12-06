package com.gauro.rabbitmqproducer.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

/**
 * @author Chandra
 */
@Slf4j
@Service
public class HelloRabbitProducer {
    private final RabbitTemplate rabbitTemplate;

    public HelloRabbitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void sendHello(String name){
        log.info("Calling sendHello======>");
        log.info("Hello "+name+ LocalTime.now().toString());
        rabbitTemplate.convertAndSend("course.hello","Hello "+name+ LocalTime.now().toString());
    }
}
