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
@Service
@Slf4j
public class PictureVectorConsumer {

    private ObjectMapper objectMapper=new ObjectMapper();

    @RabbitListener(queues = "q.picture.vector")
    public void listen(String message){
        try {
            log.info("On Vector:{}", objectMapper.readValue(message, Picture.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
