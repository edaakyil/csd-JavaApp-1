package com.edaakyil.java.app.component;

import com.karandev.io.util.console.Console;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
@Lazy
public class TimeInfo {
    public TimeInfo()
    {
        Console.writeLine("default ctor of TimeInfo");
    }

    public void displayLocalTime()
    {
        var now = LocalTime.now();

        Console.writeLine("TimeInfo: %s", now.format(DateTimeFormatter.ISO_TIME));
    }
}
