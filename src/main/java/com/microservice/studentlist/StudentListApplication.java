package com.microservice.studentlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class StudentListApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemlpate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentListApplication.class, args);
	}

}
