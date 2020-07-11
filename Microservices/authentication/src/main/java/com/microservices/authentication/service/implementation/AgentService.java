package com.microservices.authentication.service;

import com.microservices.authentication.dto.feignDTOs.AgentDTO;
import com.microservices.authentication.dto.feignDTOs.UserDTO;
import com.microservices.authentication.dto.feignDTOs.UsersDTO;
import com.microservices.authentication.dto.request.UserRequest;
import com.microservices.authentication.dto.response.UserResponse;
import com.microservices.authentication.model.Agent;
import com.microservices.authentication.model.Authority;
import com.microservices.authentication.model.User;
import com.microservices.authentication.repository.AuthorityRepository;
import com.microservices.authentication.repository.IAgentRepository;
import com.microservices.authentication.repository.UserRepository;
import com.microservices.authentication.utils.RegistrationState;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

@Service
public class AgentService {

    @Autowired
    private IAgentRepository agentRepository;


    public AgentDTO getAgent(Long id) {
        Agent agent = agentRepository.findOneById(id);
        return mapToResponse(agent);
    }

    private AgentDTO mapToResponse(Agent agent) {
        AgentDTO response = new AgentDTO();
        response.setId(agent.getId());
        response.setName(agent.getName());
        response.setEmail(agent.getEmail());
        response.setPermissionBlocked(agent.getPermissionBlocked());
        return response;
    }

    public List<AgentDTO> getAllAgents() {
        List<Agent> agents = agentRepository.findAll();
        return agents.stream().map(patient -> mapToResponse(patient)).collect(Collectors.toList());
    }

}
