package com.edaakyil.java.app.component;

import com.karandev.io.util.console.Console;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.edaakyil.spring.lib.datetime.constant.BeanName.DATE_FORMATTER_TR_BEAN;

@Component
public class DateDisplay {
    private final LocalDate m_localDate;
    private final DateTimeFormatter m_formatter;

    @Value("${app.message.date.current:Date}")
    private String m_message;

    public DateDisplay(LocalDate localDate,
                       @Qualifier(DATE_FORMATTER_TR_BEAN) DateTimeFormatter formatter)
    {
        m_localDate = localDate;
        m_formatter = formatter;
    }

    @PostConstruct
    public void displayLocalDate()
    {
        Console.writeLine("%s: %s", m_message, m_localDate.format(m_formatter));
    }
}
