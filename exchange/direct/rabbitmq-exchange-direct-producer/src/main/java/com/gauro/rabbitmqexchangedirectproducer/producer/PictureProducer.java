package com.gauro.rabbitmqexchangedirectproducer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gauro.rabbitmqexchangedirectproducer.domain.Picture;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Chandra
 */

@Service
public class PictureProducer {

    private final RabbitTemplate rabbitTemplate;

    private final ObjectMapper objectMapper=new ObjectMapper();

    public PictureProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Picture picture){
        try {
            rabbitTemplate.convertAndSend("x.picture", picture.getType(),
                    objectMapper.writeValueAsString(picture));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
