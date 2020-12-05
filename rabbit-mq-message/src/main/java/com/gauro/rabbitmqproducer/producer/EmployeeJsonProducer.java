package com.gauro.rabbitmqproducer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gauro.rabbitmqproducer.entity.Employee;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Chandra
 */
@Service
public class EmployeeJsonProducer {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public EmployeeJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Employee emp) {

        try {
            rabbitTemplate.convertAndSend("course.employee", objectMapper.writeValueAsString(emp));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
