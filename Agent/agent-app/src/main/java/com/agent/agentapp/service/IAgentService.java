package com.agent.agentapp.service;


import com.agent.agentapp.dto.request.CreateAgentRequest;
import com.agent.agentapp.dto.request.UpdateAgentRequest;
import com.agent.agentapp.dto.response.AgentResponse;

import java.util.List;

public interface IAgentService {

    AgentResponse getAgent(long id);

    List<AgentResponse> getAllAgents();

    AgentResponse createAgent(CreateAgentRequest request);

    AgentResponse updateAgent(UpdateAgentRequest request, long id);

    void deleteAgent(long id);
}
