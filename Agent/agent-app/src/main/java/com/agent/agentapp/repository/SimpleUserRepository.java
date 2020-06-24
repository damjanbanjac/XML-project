package com.agent.agentapp.repository;

import com.agent.agentapp.entity.SimpleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleUserRepository extends JpaRepository<SimpleUser, Long> {
    SimpleUser findByEmail( String mail );
}