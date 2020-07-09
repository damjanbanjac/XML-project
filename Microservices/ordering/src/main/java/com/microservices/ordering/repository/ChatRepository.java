package com.microservices.ordering.repository;

import com.microservices.ordering.model.Agent;
import com.microservices.ordering.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    Chat findById(String id);
}
