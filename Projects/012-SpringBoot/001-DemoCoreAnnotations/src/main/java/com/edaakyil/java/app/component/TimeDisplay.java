package com.edaakyil.java.app.component;

import com.karandev.io.util.console.Console;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
//@Lazy
public class TimeDisplay {
    @Autowired // Field injection
    private LocalTime m_localTime;

    @Value("${app.message.time.current}")
    private String m_message;

    @PostConstruct
    public void displayCurrentTime()
    {
        Console.writeLine("%s: %s", m_message, m_localTime.format(DateTimeFormatter.ISO_TIME));
    }
}
