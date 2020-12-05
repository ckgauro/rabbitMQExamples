package com.gauro.rabbitmqexchangeproducer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gauro.rabbitmqexchangeproducer.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Chandra
 */
@Slf4j
@Service
public class HumanResourceProducer {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper=new ObjectMapper();

    public HumanResourceProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Employee employee){

        try {
            rabbitTemplate.convertAndSend("x.hr","",  objectMapper.writeValueAsString(employee));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
