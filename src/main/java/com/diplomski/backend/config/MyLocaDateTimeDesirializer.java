package com.diplomski.backend.config;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class MyLocaDateTimeDesirializer extends JsonDeserializer<LocalDateTime> {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String dateTimeString = jsonParser.getText();

        if ("0000-00-00".equals(dateTimeString)) {
            return LocalDateTime.now();
        }
        return LocalDateTime.parse(dateTimeString,formatter);
    }
}
