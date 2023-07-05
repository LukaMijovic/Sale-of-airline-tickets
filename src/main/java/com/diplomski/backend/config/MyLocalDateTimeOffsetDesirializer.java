package com.diplomski.backend.config;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyLocalDateTimeOffsetDesirializer extends JsonDeserializer<LocalDateTime> {
    private DateTimeFormatter formatter=DateTimeFormatter.ISO_DATE_TIME;

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String dateTimeString = jsonParser.getText();
       // System.out.println(dateTimeString);
        if ("0000-00-00".equals(dateTimeString)) {
            return LocalDateTime.now();
        }
        //System.out.println(LocalDateTime.parse(dateTimeString,formatter));
        return LocalDateTime.parse(dateTimeString,formatter);
    }
}
