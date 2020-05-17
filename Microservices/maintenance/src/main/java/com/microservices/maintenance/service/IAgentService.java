package com.microservices.maintenance.service;

import com.microservices.maintenance.dto.request.CreateAgentRequest;
import com.microservices.maintenance.dto.request.UpdateAgentRequest;
import com.microservices.maintenance.dto.response.AgentResponse;

import java.util.Set;

public interface IAgentService {

    AgentResponse getAgent(long id);

    Set<AgentResponse> getAllAgents();

    AgentResponse createAgent(CreateAgentRequest request);

    AgentResponse updateAgent(UpdateAgentRequest request, long id);

    void deleteAgent(long id);
}
