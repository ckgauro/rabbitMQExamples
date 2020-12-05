package com.gauro.rabbitmqfanoutexchangeconsumer.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Chandra
 */
public class CustomLocalDateDeserializer extends StdDeserializer<LocalDate> {
    private static final long serialVersionUID = 1L;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");

    public CustomLocalDateDeserializer() {
        this(null);
    }

    protected CustomLocalDateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public LocalDate deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return LocalDate.parse(parser.readValueAs(String.class), formatter);
    }

}
