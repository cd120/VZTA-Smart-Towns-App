package com.Team4.SmartTowns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SmartTownsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartTownsApplication.class, args);
	}

}
