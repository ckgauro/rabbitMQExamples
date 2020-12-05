package com.gauro.rabbitmqproducer.bootstrap;

import com.gauro.rabbitmqproducer.producer.HelloRabbitProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Chandra
 */
@Slf4j
@Component
public class BootStrapCommand  implements CommandLineRunner {
    private final HelloRabbitProducer helloRabbitProducer;
    public BootStrapCommand(HelloRabbitProducer helloRabbitProducer) {
        this.helloRabbitProducer = helloRabbitProducer;
    }

    @Override
    public void run(String... args)  {
        log.info("=======BootStrapCommand is calling======>>>>");
        helloRabbitProducer.sendHello("Sakhsi <"+Math.random()+">");
    }
}
