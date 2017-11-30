package com.projet.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan("com.devglan")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}