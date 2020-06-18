package com.agent.agentapp.repository;

import com.agent.agentapp.entity.AdCar;
import com.agent.agentapp.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {

    Agent findOneById(Long id);
}
