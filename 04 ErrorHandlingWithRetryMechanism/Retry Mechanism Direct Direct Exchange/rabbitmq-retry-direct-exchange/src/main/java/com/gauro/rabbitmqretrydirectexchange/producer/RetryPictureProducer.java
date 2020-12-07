package com.gauro.rabbitmqretrydirectexchange.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gauro.rabbitmqretrydirectexchange.domain.Picture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Chandra
 */
@Slf4j
@Service
public class RetryPictureProducer {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper=new ObjectMapper();

    public RetryPictureProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendMessage(Picture picture){

        try {
            log.info("Picture ==>"+picture.toString());
            rabbitTemplate.convertAndSend("x.guideline.work", picture.getType(),objectMapper.writeValueAsString(picture));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
