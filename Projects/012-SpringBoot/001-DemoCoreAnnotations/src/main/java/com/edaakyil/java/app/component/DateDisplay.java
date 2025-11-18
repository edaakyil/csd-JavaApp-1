package com.edaakyil.java.app.component;

import com.karandev.io.util.console.Console;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DateDisplay {
    private final LocalDate m_localDate;

    public DateDisplay(LocalDate localDate)
    {
        m_localDate = localDate;
    }

    @PostConstruct
    public void displayLocalDate()
    {
        Console.writeLine("DateDisplay: %s", m_localDate.format(DateTimeFormatter.ISO_DATE));
    }
}
