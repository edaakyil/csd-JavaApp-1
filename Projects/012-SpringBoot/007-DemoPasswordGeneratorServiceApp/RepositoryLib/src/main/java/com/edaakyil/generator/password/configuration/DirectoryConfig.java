package com.edaakyil.generator.password.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.File;

@Configuration
public class DirectoryConfig {
    @Bean
    @Scope("prototype")
    public File directoryFile()
    {
        return new File("passwords");
    }
}
