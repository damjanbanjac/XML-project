package com.microservices.messages.service.implementation;

import com.microservices.messages.dto.AgentDTO;
import com.microservices.messages.model.Agent;
import com.microservices.messages.repository.IAgentRepository;
import com.microservices.messages.service.IAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgentService implements IAgentService {

    @Autowired
    private IAgentRepository agentRepository;

    @Override
    public List<AgentDTO> getAllAgents() {
        List<Agent> agentList = agentRepository.findAll();
        return agentList.stream().map(patient -> mapToResponse(patient)).collect(Collectors.toList());
    }

    private AgentDTO mapToResponse(Agent agent) {
        AgentDTO response = new AgentDTO();
        response.setId(agent.getId());
        response.setName(agent.getName());
        response.setAdress(agent.getAddress());
        response.setPib(agent.getPib());
        return response;
    }

    @Override
    public AgentDTO createAgent(AgentDTO agentDTO)  {
        Agent agent = new Agent();
        agent.setId((long)4);
        agent.setName("Kimi");
        agent.setAddress("Adresa");
        agent.setPib("123");
        agentRepository.save(agent);
        AgentDTO agentDTO1 = new AgentDTO(agent);
        return agentDTO1;
    }
}
