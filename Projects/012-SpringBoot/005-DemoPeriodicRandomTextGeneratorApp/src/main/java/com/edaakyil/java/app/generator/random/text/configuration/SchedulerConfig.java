package com.edaakyil.java.app.generator.random.text.configuration;

import org.csystem.scheduler.Scheduler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class SchedulerConfig {
    @Bean
    public Scheduler createScheduler(@Value("${gen.period}") int period) // Parameter injection
    {
        return Scheduler.of(period, TimeUnit.SECONDS);
    }
}
