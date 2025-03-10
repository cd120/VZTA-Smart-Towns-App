package com.Team4.SmartTowns;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SmartTownsApplication {

	public static void main(String[] args) {

		System.setProperty("spring.config.name", "application");

		SpringApplication.run(SmartTownsApplication.class, args);
	}

}
