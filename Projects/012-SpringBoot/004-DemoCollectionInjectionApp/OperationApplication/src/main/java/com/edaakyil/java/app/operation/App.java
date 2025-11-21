package com.edaakyil.java.app.operation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.edaakyil.java.app", "com.edaakyil.spring.lib.datetime", "com.edaakyil.spring.lib.operation"})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
