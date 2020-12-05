package com.gauro.rabbitmq.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gauro.rabbitmq.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Chandra
 */
@Slf4j
@Service
public class EmployeeConsumer {

    private final ObjectMapper objectMapper=new ObjectMapper();

    @RabbitListener(queues = "course.employee")
    public void listen(String message){
        Employee employee;

        try {
            employee=objectMapper.readValue(message,Employee.class);
            log.info("Employee is {} ", employee.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
