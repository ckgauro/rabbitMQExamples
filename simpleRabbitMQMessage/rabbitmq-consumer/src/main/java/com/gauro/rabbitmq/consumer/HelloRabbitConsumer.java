package com.gauro.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Chandra
 */
@Slf4j
@Service
public class HelloRabbitConsumer {

    @RabbitListener(queues = "course.hello")
    public void listen(String message){
        log.info("Consuming ===>"+message);
    }

}
