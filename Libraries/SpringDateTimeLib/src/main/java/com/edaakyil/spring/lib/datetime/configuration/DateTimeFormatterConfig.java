package com.edaakyil.spring.lib.datetime.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class DateTimeFormatterConfig {
    @Bean("com.edaakyil.time.format")
    public DateTimeFormatter formatTime()
    {
        return DateTimeFormatter.ofPattern("HH:mm:ss");
    }

    @Bean("com.edaakyil.date.format")
    public DateTimeFormatter formatDate()
    {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    @Bean("com.edaakyil.datetime.format")
    public DateTimeFormatter formatDateTime()
    {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    }
}
