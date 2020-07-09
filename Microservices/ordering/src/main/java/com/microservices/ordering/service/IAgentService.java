package com.microservices.ordering.service;

import com.microservices.ordering.dto.AgentDTO;

import java.util.List;

public interface IAgentService {

    //    AgentDTO getAgent(long id);
//
    List<AgentDTO> getAllAgents();
    //
    AgentDTO createAgent(AgentDTO request);
//
//    AgentDTO updateAgent(AgentDTO request, long id);
//
//    void deleteAgent(long id);
}