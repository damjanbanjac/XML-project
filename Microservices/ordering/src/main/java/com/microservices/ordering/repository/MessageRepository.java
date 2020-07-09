package com.microservices.ordering.repository;

import com.microservices.ordering.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
    Message findById(long id);
}
