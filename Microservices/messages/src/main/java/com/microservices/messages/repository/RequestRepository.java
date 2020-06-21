package com.microservices.messages.repository;

import com.microservices.messages.model.Order;
import com.microservices.messages.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    Request findOneById(long id);
}