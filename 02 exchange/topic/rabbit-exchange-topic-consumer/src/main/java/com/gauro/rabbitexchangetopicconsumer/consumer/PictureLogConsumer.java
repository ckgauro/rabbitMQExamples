package com.gauro.rabbitexchangetopicconsumer.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gauro.rabbitexchangetopicconsumer.domain.Picture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Chandra
 */
@Slf4j
@Service
public class PictureLogConsumer {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "q.picture.log")
    public void listen(String message){
        try {
            log.info("On Log ===>:{}" , objectMapper.readValue(message, Picture.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
