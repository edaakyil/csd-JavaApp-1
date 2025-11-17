package com.edaakyil.java.app.configuration;

import com.karandev.io.util.console.Console;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class DateTimeConfig {
    @Bean
    public LocalDateTime startTime()
    {
        var now = LocalDateTime.now();

        Console.writeLine("Start Time: %s", now.format(DateTimeFormatter.ISO_DATE_TIME));

        return now;
    }
}
