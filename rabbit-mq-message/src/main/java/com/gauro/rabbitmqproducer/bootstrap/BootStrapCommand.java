package com.gauro.rabbitmqproducer.bootstrap;

import com.gauro.rabbitmqproducer.entity.Employee;
import com.gauro.rabbitmqproducer.producer.EmployeeJsonProducer;
import com.gauro.rabbitmqproducer.producer.FixedRateProducer;
import com.gauro.rabbitmqproducer.producer.HelloRabbitProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.stream.IntStream;

/**
 * @author Chandra
 */
@Slf4j
@Component
@EnableScheduling
public class BootStrapCommand implements CommandLineRunner {
    private final HelloRabbitProducer helloRabbitProducer;
    private final FixedRateProducer fixedRateProducer;
    private final EmployeeJsonProducer employeeJsonProducer;

    public BootStrapCommand(HelloRabbitProducer helloRabbitProducer, FixedRateProducer fixedRateProducer,
                            EmployeeJsonProducer employeeJsonProducer) {
        this.helloRabbitProducer = helloRabbitProducer;
        this.fixedRateProducer = fixedRateProducer;
        this.employeeJsonProducer = employeeJsonProducer;
    }

    @Override
    public void run(String... args) {
        log.info("=======BootStrapCommand is calling======>>>>");
        helloRabbitProducer.sendHello("Sakhsi <" + Math.random() + ">");
        //  fixedRateProducer.sendMessage();
        IntStream.rangeClosed(1, 5)
                .forEach(i -> employeeJsonProducer
                        .sendMessage(new Employee("emp " + 1, "Employee " + i, LocalDate.now())));
    }
}
