package com.microservices.ordering.client;

import com.microservices.ordering.dto.AgentDTO;
import com.microservices.ordering.dto.AgentDTO2;
import com.microservices.ordering.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "authentication")
public interface AuthClient {

    @GetMapping("/auth/user")
    String getLoggedUser();

    @GetMapping("/feign/{id}/user1")
    UserDTO getUser(@PathVariable Long id);

    @GetMapping("/feign/{id}/agent")
    AgentDTO2 getAgent(@PathVariable Long id);

    @GetMapping("/feign/agents")
    List<AgentDTO2> getAgents();

    @GetMapping("/auth/users")
    List<UserDTO> getAllUsers();
}
