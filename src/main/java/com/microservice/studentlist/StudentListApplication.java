package com.microservice.studentlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class StudentListApplication {
	
	@Bean
	public RestTemplate getRestTemlpate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentListApplication.class, args);
	}

}
