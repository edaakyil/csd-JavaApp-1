package com.edaakyil.java.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Configuration
public class DateTimeConfig {
    @Bean("com.edaakyil.datetime.start")
    public LocalDateTime startDateTime()
    {
        return LocalDateTime.now();
    }

    @Bean("com.edaakyil.datetime.now")
    @Scope("prototype")
    public LocalDateTime currentDateTime()
    {
        return LocalDateTime.now();
    }

    @Bean("com.edaakyil.date.now")
    @Scope("prototype")
    public LocalDate currentDate()
    {
        return LocalDate.now();
    }

    @Bean("com.edaakyil.time.now")
    @Scope("prototype")
    public LocalTime currentTime()
    {
        return LocalTime.now();
    }
}
