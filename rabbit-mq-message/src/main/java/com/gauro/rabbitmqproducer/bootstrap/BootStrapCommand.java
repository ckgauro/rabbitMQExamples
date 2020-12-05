package com.gauro.rabbitmqproducer.bootstrap;

import com.gauro.rabbitmqproducer.producer.FixedRateProducer;
import com.gauro.rabbitmqproducer.producer.HelloRabbitProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @author Chandra
 */
@Slf4j
@Component
@EnableScheduling
public class BootStrapCommand  implements CommandLineRunner {
    private final HelloRabbitProducer helloRabbitProducer;
    private final FixedRateProducer fixedRateProducer;
    public BootStrapCommand(HelloRabbitProducer helloRabbitProducer, FixedRateProducer fixedRateProducer) {
        this.helloRabbitProducer = helloRabbitProducer;
        this.fixedRateProducer = fixedRateProducer;
    }

    @Override
    public void run(String... args)  {
        log.info("=======BootStrapCommand is calling======>>>>");
        helloRabbitProducer.sendHello("Sakhsi <"+Math.random()+">");
      //  fixedRateProducer.sendMessage();
    }
}
