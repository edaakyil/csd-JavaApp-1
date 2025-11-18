package com.edaakyil.spring.lib.datetime.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

import static com.edaakyil.spring.lib.datetime.constant.BeanName.*;

@Configuration
public class DateTimeFormatterConfig {
    @Bean(TIME_FORMATTER_TR_BEAN)
    public DateTimeFormatter createTimeFormatterTR()
    {
        return DateTimeFormatter.ofPattern("HH.mm.ss");
    }

    @Bean(DATE_FORMATTER_TR_BEAN)
    public DateTimeFormatter createDateFormatterTR()
    {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    @Bean(DATETIME_FORMATTER_TR_BEAN)
    public DateTimeFormatter createDateTimeFormatterTR()
    {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy HH.mm.ss");
    }

    @Bean(CUSTOM_TIME_FORMATTER_BEAN)
    public DateTimeFormatter createCustomTimeFormatter()
    {
        return DateTimeFormatter.ofPattern("HH.mm.ss");
    }

    @Bean(CUSTOM_DATE_FORMATTER_BEAN)
    public DateTimeFormatter createCustomDateFormatter()
    {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    @Bean(CUSTOM_DATETIME_FORMATTER_BEAN)
    public DateTimeFormatter createCustomDateTimeFormatter()
    {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy HH.mm.ss");
    }
}
