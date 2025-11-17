package com.edaakyil.java.app.configuration;

import com.karandev.io.util.console.Console;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DateTimeConfig {
    @Bean
    public LocalDateTime startDateTime()
    {
        Console.writeLine("bean of LocalDateTime in DateTimeConfig");

        return LocalDateTime.now();
    }
}
