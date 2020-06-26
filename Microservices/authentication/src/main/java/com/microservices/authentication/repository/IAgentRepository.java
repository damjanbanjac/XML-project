package com.microservices.authentication.repository;

import com.microservices.authentication.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAgentRepository extends JpaRepository<Agent, Long> {

    Agent findOneById(Long id);

}
