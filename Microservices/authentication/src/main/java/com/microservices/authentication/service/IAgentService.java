package com.microservices.authentication.service;

import com.microservices.authentication.dto.feignDTOs.AgentDTO;
import com.microservices.authentication.dto.feignDTOs.UserDTO;
import com.microservices.authentication.dto.request.UserRequest;
import com.microservices.authentication.dto.response.UserResponse;

import java.util.List;
import java.util.Set;

public interface IAgentService {

    AgentDTO getAgent();

}
