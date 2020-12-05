package com.gauro.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Chandra
 */

@Slf4j
@Service
public class FixedRateConsumer {

    @RabbitListener(queues = "course.fixedrate" , concurrency = "3")
    public void listen(String message){

        log.info("Consuming {} on thread {}", message, Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
