package com.microservices.authentication;

import com.microservices.authentication.model.Authority;
import com.microservices.authentication.repository.AuthorityRepository;
import com.microservices.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AuthenticationApplication {




	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

}
