package com.edaakyil.java.app.component;

import com.karandev.io.util.console.Console;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class StartDateTimeDisplay {
    private final LocalDateTime m_startDateTime;
    private final DateTimeFormatter m_dateTimeFormatter;

    public StartDateTimeDisplay(LocalDateTime startDateTime, DateTimeFormatter dateTimeFormatter)
    {
        m_startDateTime = startDateTime;
        m_dateTimeFormatter = dateTimeFormatter;

        Console.writeLine("default ctor of StartDateTimeDisplay");
    }

    @PostConstruct
    public void displayStartDateTime()
    {
        Console.writeLine("StartDateTimeDisplay - displayStartDateTime: %s", m_dateTimeFormatter.format(m_startDateTime));
        Console.writeLine("StartDateTimeDisplay - displayStartDateTime: %s", m_startDateTime.format(m_dateTimeFormatter));
    }
}
