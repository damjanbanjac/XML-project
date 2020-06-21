package com.agent.agentapp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@JsonSerialize
public class AgentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgentAppApplication.class, args);
	}

}
