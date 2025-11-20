package com.edaakyil.java.app.component;

import com.karandev.io.util.console.Console;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProfileMessageDisplay {
    @Value("${app.message.profile.1}")
    private String m_message1;

    @Value("${app.message.profile.2}")
    private String m_message2;

    @Value("${app.message.profile.3}")
    private String m_message3;

    @Value("${app.message.profile.4}")
    private String m_message4;

    @Value("${app.message.profile.5}")
    private String m_message5;

    @PostConstruct
    public void displayMessages()
    {
        Console.writeLine("Message-1: %s", m_message1);
        Console.writeLine("Message-2: %s", m_message2);
        Console.writeLine("Message-3: %s", m_message3);
        Console.writeLine("Message-4: %s", m_message4);
        Console.writeLine("Message-5: %s", m_message5);
    }
}

// Message-1: commandline arg
// Message-2: external-dev profile
// Message-3: external-default profile
// Message-4: internal-dev profile
// Message-5: internal-default profile