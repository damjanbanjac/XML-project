package com.microservices.messages.repository;

import com.microservices.messages.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAgentRepository extends JpaRepository<Agent, Long> {
    Agent findById(long id);
}
