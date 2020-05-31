package com.microservices.ads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdsApplication.class, args);
	}

}
