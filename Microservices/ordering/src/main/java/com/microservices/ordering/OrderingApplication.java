package com.microservices.ordering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
@EnableFeignClients
public class OrderingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderingApplication.class, args);
	}

}
