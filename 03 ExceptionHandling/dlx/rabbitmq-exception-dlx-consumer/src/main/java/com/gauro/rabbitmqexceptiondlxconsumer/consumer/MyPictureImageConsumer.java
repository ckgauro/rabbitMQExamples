package com.gauro.rabbitmqexceptiondlxconsumer.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gauro.rabbitmqexceptiondlxconsumer.domain.Picture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Chandra
 */
@Slf4j
@Service
public class MyPictureImageConsumer {
    private final ObjectMapper objectMapper=new ObjectMapper();

    @RabbitListener(queues = "q.mypicture.image")
    public void listen(String message){
        try {
            var picture=objectMapper.readValue(message, Picture.class);
            if(picture.getSize()>9000){
                throw new IllegalArgumentException("Picture size is too large: "+picture.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
