package com.gauro.rabbitmqproducer.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Chandra
 */
@Service
@Slf4j
public class FixedRateProducer {

    private final RabbitTemplate rabbitTemplate;
    private static int i=0;

    public FixedRateProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedRate = 500)
    public void sendMessage(){
        i++;
        log.info("Fixed Rate "+i);
        rabbitTemplate.convertAndSend("course.fixedrate"," Fixed Rate :"+i);

    }
}
