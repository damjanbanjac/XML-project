package com.microservices.messages.repository;

import com.microservices.messages.model.Agent;
import com.microservices.messages.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChatRepository extends JpaRepository<Chat, Long> {
    Chat findById(String id);
}
