package com.example.demo.configuration;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class JsonConfig {

    //@Value("cinema.dateformat")
    private String dateFormat = "dd.MM.yyyy.";
    //@Value("cinema.datetimeformat")
    private String dateTimeFormat = "dd.MM.yyyy. HH:mm:ss";

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonDeserializerCustomizer() {
        return builder -> {
            builder.simpleDateFormat(dateTimeFormat);
            builder.deserializers(new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(dateFormat)));
            builder.deserializers(new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
        };
    }

}
