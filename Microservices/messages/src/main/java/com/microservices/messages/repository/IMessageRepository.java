package com.microservices.messages.repository;

import com.microservices.messages.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessageRepository extends JpaRepository<Message,Long> {
    Message findById(long id);
}
