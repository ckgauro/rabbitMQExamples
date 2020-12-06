package com.gauro.rabbitmqexchangetopicproducer.bootstrap;

import com.gauro.rabbitmqexchangetopicproducer.domain.Picture;
import com.gauro.rabbitmqexchangetopicproducer.producer.PictureProducer;
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
public class BootStrap  implements CommandLineRunner {
    private final PictureProducer pictureProducer;

    private final List<String> SOURCES = List.of("mobile", "web");

    private final List<String> TYPES = List.of("jpg", "png", "svg");

    public BootStrap(PictureProducer pictureProducer) {
        this.pictureProducer = pictureProducer;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("*************************Called*********");
        IntStream.rangeClosed(1, 30)
                .forEach(i -> pictureProducer.sendMessage(
                        Picture.builder()
                                .name("picture " + i)
                                .size(ThreadLocalRandom.current().nextLong(1, 1001))
                                .source(SOURCES.get(i % SOURCES.size()))
                                .type(TYPES.get(i % TYPES.size()))
                                .build()
                ));



    }
}
