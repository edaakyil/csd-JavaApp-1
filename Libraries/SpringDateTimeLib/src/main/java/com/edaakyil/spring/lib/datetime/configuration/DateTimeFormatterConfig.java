package com.edaakyil.spring.lib.datetime.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.format.DateTimeFormatter;

import static com.edaakyil.spring.lib.datetime.constant.BeanName.*;

@Configuration
public class DateTimeFormatterConfig {
    @Bean(TIME_FORMATTER_TR_BEAN)
    public DateTimeFormatter createTimeFormatterTR()
    {
        return DateTimeFormatter.ofPattern("HH:mm:ss");
    }

    @Bean(DATE_FORMATTER_TR_BEAN)
    public DateTimeFormatter createDateFormatterTR()
    {
        return DateTimeFormatter.ofPattern("dd.MM.yyyy");
    }

    @Bean(DATETIME_FORMATTER_TR_BEAN)
    @Primary
    public DateTimeFormatter createDateTimeFormatterTR()
    {
        return DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    }

    @Bean(CUSTOM_TIME_FORMATTER_BEAN)
    public DateTimeFormatter createCustomTimeFormatter(
            @Value("${com.edaakyil.time.format.custom:hh:mm:ss a}") String pattern)
    {
        return DateTimeFormatter.ofPattern(pattern);
    }

    @Bean(CUSTOM_DATE_FORMATTER_BEAN)
    public DateTimeFormatter createCustomDateFormatter(
            @Value("${com.edaakyil.date.format.custom:dd-MM-yyyy}") String pattern)
    {
        return DateTimeFormatter.ofPattern(pattern);
    }

    @Bean(CUSTOM_DATETIME_FORMATTER_BEAN)
    public DateTimeFormatter createCustomDateTimeFormatter(
            @Value("${com.edaakyil.datetime.format.custom:dd-MM-yyyy hh:mm:ss a}") String pattern)
    {
        return DateTimeFormatter.ofPattern(pattern);
    }
}
