package com.edaakyil.java.app.component;

import com.karandev.io.util.console.Console;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DateDisplay {
    public DateDisplay()
    {
        Console.writeLine("default ctor of DateDisplay");
    }
}
