package com.gauro.rabbitmqexchangetopicproducer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gauro.rabbitmqexchangetopicproducer.domain.Picture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Chandra
 */
@Slf4j
@Service
public class PictureProducer {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper=new ObjectMapper();

    public PictureProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendMessage(Picture picture){
        var sb=new StringBuilder();
        sb.append(picture.getSource());
        sb.append(".");
        sb.append(picture.getSize()>4000?"large":"small");
        sb.append(".");
        sb.append(picture.getType());
        try {
            var json=objectMapper.writeValueAsString(picture);
            var routingKey=sb.toString();
            log.info("Routing  values for {} is ====>{}",picture.toString(), routingKey);
            rabbitTemplate.convertAndSend("x.picture",routingKey,json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
