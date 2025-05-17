package com.peopleconnected.PeopleConnected;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PeopleConnectedApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopleConnectedApplication.class, args);
		System.out.println("Server Running...");
	}

}
