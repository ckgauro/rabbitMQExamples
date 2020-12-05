package com.gauro.rabbitmqexchangeproducer.bootstrap;

import com.gauro.rabbitmqexchangeproducer.domain.Employee;
import com.gauro.rabbitmqexchangeproducer.producer.HumanResourceProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.stream.IntStream;

/**
 * @author Chandra
 */

@Component
public class BootStrap implements CommandLineRunner {

    private final HumanResourceProducer humanResourceProducer;

    public BootStrap(HumanResourceProducer humanResourceProducer) {
        this.humanResourceProducer = humanResourceProducer;
    }

    @Override
    public void run(String... args) throws Exception {
        IntStream.rangeClosed(1, 5)
                .forEach(i -> humanResourceProducer.sendMessage(
                        new Employee("emp " + i, "Employee " + i, LocalDate.now())
                ));

    }
}
