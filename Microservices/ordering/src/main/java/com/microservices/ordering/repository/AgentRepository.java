package com.microservices.ordering.repository;

import com.microservices.ordering.model.Agent;
import com.microservices.ordering.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Users, Long> {

    Agent findOneById(long id);
}
