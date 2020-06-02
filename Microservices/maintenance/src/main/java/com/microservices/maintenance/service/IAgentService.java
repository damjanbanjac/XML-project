package com.microservices.maintenance.service;

import com.microservices.maintenance.dto.request.CreateAgentRequest;
import com.microservices.maintenance.dto.request.UpdateAgentRequest;
import com.microservices.maintenance.dto.response.AgentResponse;

import java.util.List;

public interface IAgentService {

    AgentResponse getAgent(long id);

    List<AgentResponse> getAllAgents();

    AgentResponse createAgent(CreateAgentRequest request);

    AgentResponse updateAgent(UpdateAgentRequest request, long id);

    void deleteAgent(long id);
}
