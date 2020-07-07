package com.agent.agentapp.repository;

import com.agent.agentapp.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    Request findOneById(long id);
}
