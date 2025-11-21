package com.edaakyil.java.app.runner;

import com.karandev.io.util.console.Console;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationRunnerConfig {
    private void applicationRunnerCallback(ApplicationArguments applicationArguments)
    {
        Console.writeLine("Application runner");
    }

    @Bean
    public ApplicationRunner createApplicationRunner()
    {
        return this::applicationRunnerCallback;
    }
}
