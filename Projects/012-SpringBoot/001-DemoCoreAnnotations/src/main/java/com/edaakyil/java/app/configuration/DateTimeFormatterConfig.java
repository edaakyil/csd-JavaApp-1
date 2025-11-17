package com.edaakyil.java.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class DateTimeFormatterConfig {
    @Bean("com.edaakyil.datetime.format")
    public DateTimeFormatter createDateTimeFormatter()
    {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    }

    @Bean("com.edaakyil.date.format")
    public DateTimeFormatter createDateFormatter()
    {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    @Bean("com.edaakyil.time.format")
    public DateTimeFormatter createTimeFormatter()
    {
        return DateTimeFormatter.ofPattern("HH:mm:ss");
    }
}
