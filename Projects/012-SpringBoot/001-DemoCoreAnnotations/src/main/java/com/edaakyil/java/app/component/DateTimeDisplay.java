package com.edaakyil.java.app.component;

import com.karandev.io.util.console.Console;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.edaakyil.spring.lib.datetime.constant.BeanName.DATETIME_FORMATTER_TR_BEAN;
import static com.edaakyil.spring.lib.datetime.constant.BeanName.LOCAL_CURRENT_DATETIME_BEAN;

/*
* DateTimeFormatter -> enjekte edilerek alındı (enjekye ettik)
* LocalDateTime değeri -> getBean metodundan alındı
*/

@Component
@Scope("prototype")
public class DateTimeDisplay {
    private final ApplicationContext m_context;
    private final DateTimeFormatter m_formatter;

    public DateTimeDisplay(ApplicationContext context,
                           DateTimeFormatter formatter)
    {
        m_context = context;
        m_formatter = formatter;
    }

    @PostConstruct
    public void displayDateTime()
    {
        // Kodun istediğimiz bir akışında bean'lere ilişkin değerleri almak istersek:
        // (Bu yöntem ile bean'lere ilişkin değerler Runtime'da alınıyor):
        var now = m_context.getBean(LOCAL_CURRENT_DATETIME_BEAN, LocalDateTime.class);

        //Console.writeLine("DateTimeDisplay: %s", m_formatter.format(now));
        Console.writeLine("DateTimeDisplay: %s", now.format(m_formatter));
    }
}
