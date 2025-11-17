package com.edaakyil.java.app.component;

import com.karandev.io.util.console.Console;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class StartDateTimeDisplay {
    private final LocalDateTime m_startDateTime;
    private final DateTimeFormatter m_dateTimeFormatter;

    // StartDateTimeDisplay'e constructor injection yöntemi ile LocalDateTime ve DateTimeFormatter türlerini enjekte ettik.
    // constructor ile yapılan bu enjeckte işlemine dependency injection literatüründe "constructor injection" denilir.
    public StartDateTimeDisplay(@Qualifier("com.edaakyil.datetime.start") LocalDateTime startDateTime,
                                @Qualifier("com.edaakyil.datetime.format") DateTimeFormatter dateTimeFormatter)
    {
        m_startDateTime = startDateTime;
        m_dateTimeFormatter = dateTimeFormatter;

        Console.writeLine("default ctor of StartDateTimeDisplay");
    }

    @PostConstruct
    public void displayStartDateTime()
    {
        //Console.writeLine("StartDateTimeDisplay - displayStartDateTime: %s", m_dateTimeFormatter.format(m_startDateTime));
        Console.writeLine("StartDateTimeDisplay - displayStartDateTime: %s", m_startDateTime.format(m_dateTimeFormatter));
    }
}
