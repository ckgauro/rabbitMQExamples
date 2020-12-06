package com.gauro.rabbitmqexceptiondlxproducer.bootstrap;


import com.gauro.rabbitmqexceptiondlxproducer.domain.Picture;
import com.gauro.rabbitmqexceptiondlxproducer.producer.MyPictureProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * @author Chandra
 */
@Slf4j
@Component
public class BootStrap implements CommandLineRunner {
    private final MyPictureProducer pictureProducer;

    private final List<String> SOURCES = List.of("mobile", "web");

    private final List<String> TYPES = List.of("jpg", "png", "svg");

    public BootStrap(MyPictureProducer pictureProducer) {
        this.pictureProducer = pictureProducer;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("*************************Called*********");
        IntStream.rangeClosed(1, 100)
                .forEach(i -> pictureProducer.sendMessage(
                        Picture.builder()
                                .name("picture " + i)
                                .size(ThreadLocalRandom.current().nextLong(9001, 10001))
                                .source(SOURCES.get(i % SOURCES.size()))
                                //.source("web")
                                .type(TYPES.get(i % TYPES.size()))
                                .build()
                ));
    }
}
