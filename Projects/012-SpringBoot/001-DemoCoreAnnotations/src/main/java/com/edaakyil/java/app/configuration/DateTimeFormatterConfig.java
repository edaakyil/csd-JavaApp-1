package com.edaakyil.java.app.configuration;

import com.karandev.io.util.console.Console;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class DateTimeFormatterConfig {
    @Bean
    public DateTimeFormatter createDateTimeFormatter()
    {
        Console.writeLine("bean of DateTimeFormatter in DateTimeFormatterConfig");

        return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    }
}
