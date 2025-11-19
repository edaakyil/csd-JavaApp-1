package com.edaakyil.java.app.component;

import com.karandev.io.util.console.Console;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.edaakyil.spring.lib.datetime.constant.BeanName.DATETIME_FORMATTER_TR_BEAN;
import static com.edaakyil.spring.lib.datetime.constant.BeanName.LOCAL_START_DATETIME_BEAN;

@Component
public class StartDateTimeDisplay {
    private final LocalDateTime m_startDateTime;
    private final DateTimeFormatter m_dateTimeFormatter;

    // Property injection
    // .properties dosyasından otomatik olarak enjekte etmesi için @Value annotation'ı kullanılır
    @Value("${app.message.datetime.start}")
    private String m_message;

    // StartDateTimeDisplay'e constructor injection yöntemi ile LocalDateTime ve DateTimeFormatter türlerini enjekte ettik.
    // constructor ile yapılan bu enjeckte işlemine dependency injection literatüründe "constructor injection" denilir.
    public StartDateTimeDisplay(@Qualifier(LOCAL_START_DATETIME_BEAN) LocalDateTime startDateTime,
                                @Qualifier(DATETIME_FORMATTER_TR_BEAN) DateTimeFormatter dateTimeFormatter)
    {
        m_startDateTime = startDateTime;
        m_dateTimeFormatter = dateTimeFormatter;
    }

    @PostConstruct
    public void displayStartDateTime()
    {
        //Console.writeLine("StartDateTimeDisplay: %s", m_dateTimeFormatter.format(m_startDateTime));
        Console.writeLine("%s: %s", m_message, m_startDateTime.format(m_dateTimeFormatter));
    }
}
