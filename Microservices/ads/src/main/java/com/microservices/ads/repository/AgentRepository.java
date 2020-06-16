package com.microservices.ads.repository;

import com.microservices.ads.model.AdCar;
import com.microservices.ads.model.Agent;
import com.microservices.ads.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
    Agent findOneById(Long id);
}

