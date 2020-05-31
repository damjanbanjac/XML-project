package com.microservices.authentication;

import com.microservices.authentication.model.Authority;
import com.microservices.authentication.repository.AuthorityRepository;
import com.microservices.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class AuthenticationApplication {




	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

}
