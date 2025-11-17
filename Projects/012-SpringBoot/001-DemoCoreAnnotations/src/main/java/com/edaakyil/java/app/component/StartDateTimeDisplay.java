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

    // StartDateTimeDisplay'e LocalDateTime ve DateTimeFormatter enjekte ettik.
    // constructor ile yapılan bu enjeckte işlemine dependency injection literatüründe "constructor injection" denilir.
    // StartDateTimeDisplay sınıfına constructor injection yöntemiyle LocalDateTime ve DateTimeFormatter'ı
    // DateTimeConfig'deki startDateTime metodundan LocalDateTime ve DateTimeFormatterConfig'deki createDateTimeFormatter
    // metodundan DateTimeFormatter'ı elde ettik.
    public StartDateTimeDisplay(LocalDateTime startDateTime, DateTimeFormatter dateTimeFormatter)
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
