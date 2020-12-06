package com.gauro.rabbitmqexceptiondlx.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gauro.rabbitmqexceptiondlx.domain.Picture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Chandra
 */
@Slf4j
@Service
public class MyPictureProducer {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper=new ObjectMapper();

    public MyPictureProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendMessage(Picture picture){

        try {
            log.info("Picture ==>"+picture.toString());
            rabbitTemplate.convertAndSend("x.mypicture","",objectMapper.writeValueAsString(picture));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
