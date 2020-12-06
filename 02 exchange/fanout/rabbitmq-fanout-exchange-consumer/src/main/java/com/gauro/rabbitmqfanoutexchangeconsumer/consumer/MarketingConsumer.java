package com.gauro.rabbitmqfanoutexchangeconsumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gauro.rabbitmqfanoutexchangeconsumer.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Chandra
 */
@Slf4j
@Service
public class MarketingConsumer {
    private ObjectMapper objectMapper=new ObjectMapper();

    @RabbitListener(queues = "q.hr.marketing")
    public  void listen(String message){

        Employee employee=null;

        try {
            log.info("On Marketing , employee is {}", objectMapper.readValue(message,Employee.class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}
