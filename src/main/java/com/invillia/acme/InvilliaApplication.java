package com.invillia.acme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
//@EnableWebSecurity
public class InvilliaApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvilliaApplication.class, args);
	}
}
