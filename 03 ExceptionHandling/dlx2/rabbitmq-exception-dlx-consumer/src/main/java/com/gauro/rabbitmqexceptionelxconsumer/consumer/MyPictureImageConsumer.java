package com.gauro.rabbitmqexceptionelxconsumer.consumer;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gauro.rabbitmqexceptionelxconsumer.domain.Picture;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
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
    public void listen(Message message, Channel channel){
        try {
            var picture=objectMapper.readValue(message.getBody(), Picture.class);
            if(picture.getSize()>9000){
                channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
            }
            log.info("On Image :{}", picture.toString());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
