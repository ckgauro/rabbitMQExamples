package com.gauro.rabbitmq.json;

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

    private static  final long serialVersionUID=1l;
    private static DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MMM-dd");

    protected CustomLocalDateDeserializer() {
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return LocalDate.parse(parser.readValueAs(String.class),dateTimeFormatter);
    }
}
