package com.edaakyil.spring.lib.datetime.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Configuration
public class DateTimeConfig {
    @Bean("com.edaakyil.time.current")
    @Scope("prototype")
    public LocalTime currentTime()
    {
        return LocalTime.now();
    }

    @Bean("com.edaakyil.date.current")
    @Scope("prototype")
    public LocalDate currentDate()
    {
        return LocalDate.now();
    }

    @Bean("com.edaakyil.datetime.current")
    @Scope("prototype")
    public LocalDateTime currentLocalDateTime()
    {
        return LocalDateTime.now();
    }

    @Bean("com.edaakyil.datetime.start")
    public LocalDateTime startDateTime()
    {
        return LocalDateTime.now();
    }
}
