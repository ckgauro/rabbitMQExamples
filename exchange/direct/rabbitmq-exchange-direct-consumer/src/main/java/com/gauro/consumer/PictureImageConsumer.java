package com.gauro.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gauro.domain.Picture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Chandra
 */
@Slf4j
@Service
public class PictureImageConsumer {
    private ObjectMapper objectMapper=new ObjectMapper();

    @RabbitListener(queues = "q.picture.image")
    public void listen(String message){

        try {
            log.info("On image : {} ", objectMapper.readValue(message, Picture.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
