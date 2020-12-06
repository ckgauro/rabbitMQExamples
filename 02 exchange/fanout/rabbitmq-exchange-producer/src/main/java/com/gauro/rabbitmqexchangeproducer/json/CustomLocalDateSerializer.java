package com.gauro.rabbitmqexchangeproducer.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Chandra
 */
public class CustomLocalDateSerializer extends StdSerializer<LocalDate> {

    private static final long serialVersionUID=1L;
    private static DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MMM-dd");

    public CustomLocalDateSerializer() {
        this(null);
       // this(null);
    }
    public CustomLocalDateSerializer(Class<LocalDate> t) {
        super(t);
    }


    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(dateTimeFormatter.format(value));

    }
}
