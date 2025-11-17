package com.edaakyil.java.app.configuration;

import com.karandev.io.util.console.Console;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration
public class DateTimeConfig {
    @Bean("com.edaakyil.datetime.start")
    public LocalDateTime startDateTime()
    {
        Console.writeLine("bean of LocalDateTime in DateTimeConfig - startDateTime");

        return LocalDateTime.now();
    }

    @Bean("com.edaakyil.datetime.now")
    @Scope("prototype")
    public LocalDateTime currentDateTime()
    {
        Console.writeLine("bean of LocalDateTime in DateTimeConfig - currentDateTime");

        return LocalDateTime.now();
    }
}
